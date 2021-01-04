package com.github.hcsp.aspect;

import com.github.hcsp.annotation.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author Ruby
 * @date 2021/1/4 11:17
 */
@Aspect
@Component
public class CacheAspect {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(cache)")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint, Cache cache) {
        String cacheKey = proceedingJoinPoint.getSignature().getName() + Arrays.toString(proceedingJoinPoint.getArgs());
        Object proceed;

        proceed = redisTemplate.opsForValue().get(cacheKey);
        if (proceed != null) {
            return proceed;
        }
        try {
            int timeout = cache.value();
            proceed = proceedingJoinPoint.proceed();
            redisTemplate.opsForValue().set(cacheKey, proceed, timeout, TimeUnit.SECONDS);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
