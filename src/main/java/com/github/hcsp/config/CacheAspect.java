package com.github.hcsp.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class CacheAspect {

    private RedisTemplate redisTemplate;

    @Autowired
    public CacheAspect(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.github.hcsp.config.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String name = signature.getName();
        int cacheSeconds = proceedingJoinPoint.getTarget()
                .getClass()
                .getMethod(name, signature.getParameterTypes())
                .getAnnotation(Cache.class).cacheSeconds();

        ValueOperations opsForValue = redisTemplate.opsForValue();
        Object cachedValue = opsForValue.get(name);
        if (cachedValue == null) {
            cachedValue = proceedingJoinPoint.proceed();
            opsForValue.set(name, cachedValue, cacheSeconds, TimeUnit.SECONDS);
        }
        return cachedValue;
    }
}

