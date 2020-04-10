package com.github.hcsp.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class RedisAopCache {
    final
    RedisTemplate<String, Object> redisTemplate;

    public RedisAopCache(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.github.hcsp.annotation.RedisAopCache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        Object cacheValue = redisTemplate.opsForValue().get(methodName);

        if (cacheValue != null) {
            System.out.println("get value from cache!");
            return cacheValue;
        } else {
            System.out.println("get value from database!");
            Object realValue = joinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, realValue);
            redisTemplate.expire(methodName, 1, TimeUnit.SECONDS);
            return realValue;
        }
    }
}
