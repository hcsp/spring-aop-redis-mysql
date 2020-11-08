package com.github.hcsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Aspect
@Configuration
public class CacheAspect {

    @Autowired
    RedisTemplate<String, CacheItem> redisTemplate;

    public boolean isCacheValid(CacheItem cacheItem) {
        return (System.currentTimeMillis() - cacheItem.getTime()) < 1000;
    }

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final String methodName = proceedingJoinPoint.getSignature().getName();
        CacheItem cacheItem = redisTemplate.opsForValue().get(methodName);
        if (cacheItem != null) {
            if (isCacheValid(cacheItem)) {
                return cacheItem.getCacheValue();
            }
        }
        Object methodReturnValue = proceedingJoinPoint.proceed();
        redisTemplate.opsForValue().set(methodName, new CacheItem(System.currentTimeMillis(), methodReturnValue));
        return methodReturnValue;
    }
}
