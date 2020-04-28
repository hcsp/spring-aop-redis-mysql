package com.github.hcsp.Service;

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

    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public CacheAspect(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        String methodName = signature.getName();
        Object cachedValue = redisTemplate.opsForValue().get(methodName);
        if (cachedValue != null) {
            return cachedValue;
        } else {
            Object realValue = joinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, realValue, 1_000_000, TimeUnit.MICROSECONDS);
            return realValue;

        }
    }
}
