package com.github.hcsp;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.entity.CacheValue;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Configuration
public class CacheAspect {
    private final RedisTemplate<String, CacheValue> redisCache;

    public CacheAspect(RedisTemplate<String, CacheValue> redisCache) {
        this.redisCache = redisCache;
    }

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String cacheKey = signature.getName();
        CacheValue cacheValue = redisCache.opsForValue().get(cacheKey);

        int cacheDuration = signature.getMethod().getAnnotation(Cache.class).value();

        if (cacheValue != null && Duration.between(cacheValue.getCacheTime(), Instant.now()).getSeconds() < cacheDuration) {
            return cacheValue.getValue();
        } else {
            Object realValue = proceedingJoinPoint.proceed();
            redisCache.opsForValue().set(cacheKey, new CacheValue(Instant.now(), realValue));
            return realValue;
        }
    }
}
