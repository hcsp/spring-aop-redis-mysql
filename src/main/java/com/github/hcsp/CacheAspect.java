package com.github.hcsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Aspect
public class CacheAspect {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.annotations.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {

        String signature = joinPoint.getSignature().toString();
        Long cachedTime = (Long) redisTemplate.opsForHash().get(signature, "cachedTime");
        Object cachedValue = redisTemplate.opsForHash().get(signature, "cachedValue");

        if (cachedTime != null && System.currentTimeMillis() - cachedTime <= 1000) {
            System.out.println("Get value from Cache!");
            return cachedValue;
        } else {
            System.out.println("Get value from database!");
            Object newValue = joinPoint.proceed();
            redisTemplate.opsForHash().put(signature, "cachedTime", System.currentTimeMillis());
            redisTemplate.opsForHash().put(signature, "cachedValue", newValue);
            return newValue;
        }
    }
}

