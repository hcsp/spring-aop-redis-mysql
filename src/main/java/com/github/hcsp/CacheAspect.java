package com.github.hcsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author Zhaofeng Zhou
 * @date 2021/8/3/003 22:48
 */
@Aspect
@Configuration
public class CacheAspect {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.annotation.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();

        Object cacheValue = redisTemplate.opsForValue().get(methodName);

        if (cacheValue != null) {
            System.out.println("get data from cache");
            return cacheValue;
        } else {
            System.out.println("get data from database");
            Object realValue = joinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, realValue);
            redisTemplate.expire(methodName, 1, TimeUnit.SECONDS);
            return realValue;
        }

    }
}
