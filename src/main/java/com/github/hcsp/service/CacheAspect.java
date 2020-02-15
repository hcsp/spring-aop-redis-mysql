package com.github.hcsp.service;

import com.github.hcsp.annotation.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class CacheAspect {
    @Autowired
    RedisTemplate redisTemplate;

    @Around("@annotation(com.github.hcsp.annotation.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        Object cacheValue = redisTemplate.opsForValue().get(methodName);
        int expireTime = signature.getMethod().getAnnotation(Cache.class).cacheSeconds();
        if (cacheValue != null) {
            System.out.println("load from Redis!");
            return cacheValue;
        } else {
            System.out.println("load from database!");
            Object newValue = joinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, newValue, expireTime, TimeUnit.SECONDS);
            return newValue;
        }
    }
}
