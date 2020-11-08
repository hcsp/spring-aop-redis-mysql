package com.github.hcsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class CacheAspect {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final String methodName = proceedingJoinPoint.getSignature().getName();
        Object cacheValue = redisTemplate.opsForValue().get(methodName);
        if (cacheValue != null) {
            return cacheValue;
        }
        Object methodReturnValue = proceedingJoinPoint.proceed();
        redisTemplate.opsForValue().set(methodName, methodReturnValue, 1, TimeUnit.SECONDS);
        return methodReturnValue;
    }
}
