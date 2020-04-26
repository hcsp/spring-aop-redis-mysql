package com.github.hcsp;

import com.github.hcsp.annotation.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class CacheAspect {
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.annotation.Cache)")
    public Object cache(final ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        long timeout = signature.getMethod().getAnnotation(Cache.class).cacheSeconds();
        String methodName = signature.getName();

        String className = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();

        Object cacheKey = new CacheKey(methodName, className, args);

        Object cachedValue = redisTemplate.opsForValue().get(cacheKey);

        if (cachedValue != null) {
            System.out.println("From cache");
            return cachedValue;
        } else {
            System.out.println("From database!");
            Object actualValue = joinPoint.proceed();
            redisTemplate.opsForValue().set(cacheKey, actualValue, timeout, TimeUnit.SECONDS);
            return actualValue;
        }
    }

    static class CacheKey implements Serializable {
        private String methodName;
        private String className;
        private Object[] arguments;

        CacheKey(String methodName, String className, Object[] arguments) {
            this.methodName = methodName;
            this.className = className;
            this.arguments = arguments;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) o;
            return methodName.equals(cacheKey.methodName) &&
                    className.equals(cacheKey.className) &&
                    Arrays.equals(arguments, cacheKey.arguments);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(methodName, className);
            result = 31 * result + Arrays.hashCode(arguments);
            return result;
        }
    }
}

