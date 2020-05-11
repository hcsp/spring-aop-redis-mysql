package com.github.hcsp.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class CacheAspect {
    final
    RedisTemplate<String, Object> redisTemplate;

    public CacheAspect(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("call CacheAspect success!");
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        Object cacheValue = redisTemplate.opsForValue().get(methodName);
        if (cacheValue == null) {
            System.out.println("no cache");
            Object realValue = proceedingJoinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, realValue, 1, TimeUnit.SECONDS);
            return realValue;
        } else {
            System.out.println("have cache");
            return cacheValue;
        }
    }
}
