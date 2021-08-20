package com.github.hcsp;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.entity.CacheKey;
import com.github.hcsp.entity.CacheValue;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Instant;

@Aspect
@Configuration
public class CacheAspect {
    private final RedisTemplate<CacheKey, CacheValue> redisTemplate;

    public CacheAspect(RedisTemplate<CacheKey, CacheValue> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Cache cacheAnnotation = methodSignature.getMethod().getAnnotation(Cache.class);
        String methodName = methodSignature.getName();
        Object[] args = proceedingJoinPoint.getArgs();
        Object caller = proceedingJoinPoint.getThis();
        CacheKey cacheKey = new CacheKey(methodName, args, caller);

        CacheValue cacheValue = redisTemplate.opsForValue().get(cacheKey);
        int cacheDuration = cacheAnnotation.value();
        Instant currentInstant = Instant.now();
        if (cacheValue != null && currentInstant.getNano() - cacheValue.getCacheTime().getNano() < cacheDuration * 1000) {
            System.out.println("cache");
            return cacheValue.getValue();
        } else {
            System.out.println("database");
            Object realValue = proceedingJoinPoint.proceed();
            redisTemplate.opsForValue().set(cacheKey, new CacheValue(realValue, currentInstant));
            return realValue;
        }
    }
}
