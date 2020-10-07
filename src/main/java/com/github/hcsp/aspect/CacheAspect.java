package com.github.hcsp.aspect;

import com.github.hcsp.annotation.MyCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class CacheAspect {
    @Inject
    private RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.annotation.MyCache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        Object cachedValue = redisTemplate.opsForValue().get(methodName);
        if (cachedValue != null) {
            return cachedValue;
        } else {
            long durationSeconds = getMethodCacheDuration(proceedingJoinPoint);
            Object result = proceedingJoinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, result, durationSeconds, TimeUnit.SECONDS);
            return result;
        }
    }

    private long getMethodCacheDuration(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        return methodSignature.getMethod().getAnnotation(MyCache.class).durationSeconds();
    }
}
