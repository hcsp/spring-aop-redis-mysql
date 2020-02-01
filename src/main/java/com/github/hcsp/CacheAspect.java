package com.github.hcsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@Aspect
@Configuration
public class CacheAspect {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = signature.getName();

        Object cachedValue = redisTemplate.opsForValue().get(methodName);
        if (cachedValue != null) {
            System.out.println("缓存");
            return cachedValue;
        } else {
            System.out.println("数据库");
            Object realVal = proceedingJoinPoint.proceed();
            Duration duration = Duration.ofSeconds(1);
            redisTemplate.opsForValue().set(methodName, realVal, duration);
            return realVal;
        }

    }
}
