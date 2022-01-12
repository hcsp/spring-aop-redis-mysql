package com.github.hcsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
@Aspect
public class CacheAspect {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        Object cachedValue = redisTemplate.opsForValue().get(methodName);
        if (cachedValue != null) {
            System.out.println(2);
            return cachedValue;
        } else {
            System.out.println(1);
            Object realValue = joinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, realValue, 1, TimeUnit.SECONDS);
            return realValue;
        }
    }
}
