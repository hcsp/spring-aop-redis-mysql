package com.github.hcsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Objects;

@Aspect
@Configuration
public class CacheAspect {
    @Resource
    RedisTemplate<Object, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.annotation.Cache)")
    public Object cache(final ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        String methodName = signature.getName();
        Object target = joinPoint.getTarget();
        Object[] args = joinPoint.getArgs();

        Object cacheKey = (Object) new CacheKey(methodName, target, args);

        Object cachedValue = redisTemplate.opsForValue().get(cacheKey);

        if (cachedValue != null) {
            System.out.println("From cache!");
            return cachedValue;
        } else {
            System.out.println("From database!");
            Object actualValue = joinPoint.proceed();
            redisTemplate.opsForValue().set(cacheKey, actualValue);
            return actualValue;
        }
    }

    public static class CacheKey {
        private String methodName;
        private Object thisObject;
        private Object[] arguments;

        public CacheKey(String methodName, Object thisObject, Object[] arguments) {
            this.methodName = methodName;
            this.thisObject = thisObject;
            this.arguments = arguments;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CacheKey cacheKey = (CacheKey) o;
            return methodName.equals(cacheKey.methodName) &&
                    thisObject.equals(cacheKey.thisObject) &&
                    Arrays.equals(arguments, cacheKey.arguments);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(methodName, thisObject);
            result = 31 * result + Arrays.hashCode(arguments);
            return result;
        }
    }
}

