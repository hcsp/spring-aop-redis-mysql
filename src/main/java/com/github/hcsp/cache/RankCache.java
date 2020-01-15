package com.github.hcsp.cache;

import com.github.hcsp.anno.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Aspect
public class RankCache {
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public RankCache(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        int expireTime = signature.getMethod().getAnnotation(Cache.class).cacheSeconds();
        String name = joinPoint.getSignature().getName();
        Object value = redisTemplate.opsForValue().get(name);
        if (value != null) {
            return value;
        } else {
            Object proceed = joinPoint.proceed();
            redisTemplate.opsForValue().set(name, proceed);
            redisTemplate.opsForValue().set(name, proceed, expireTime, TimeUnit.SECONDS);
            return proceed;
        }
    }

}
