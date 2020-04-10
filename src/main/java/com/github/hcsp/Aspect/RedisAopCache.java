package com.github.hcsp.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class RedisAopCache {
    @Resource
    RedisTemplate<String, Object> redisTemplate;

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
            redisTemplate.opsForValue().set(methodName, realValue, 20, TimeUnit.SECONDS);
            return realValue;
        }
    }
}
