package com.github.hcsp;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
@Aspect
public class CacheAspect {
    private final RedisTemplate<String, Object> redisTempe;

    public CacheAspect(RedisTemplate<String, Object> redisTempe) {
        this.redisTempe = redisTempe;
    }

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint point) throws Throwable {
        Signature signature = point.getSignature();
        String methodName = signature.getName();
        redisTempe.opsForValue().set("cacheTime", 1000);
        Object cachedValue = redisTempe.opsForValue().get(methodName);
        if (cachedValue != null) {
            System.out.println("has cache value :" + cachedValue);
            return cachedValue;
        } else {
            Object realValue = point.proceed();
            redisTempe.opsForValue().set(methodName, realValue, 1, TimeUnit.SECONDS);
            System.out.println("no have cache or exceed time  ,new cache value is:" + realValue);
            return realValue;
        }
    }
}
