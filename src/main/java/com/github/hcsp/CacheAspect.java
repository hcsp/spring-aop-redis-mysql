package com.github.hcsp;

import com.github.hcsp.anno.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class CacheAspect {
    final
    RedisTemplate<String, Object> redisTemplate;

    public CacheAspect(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        int expireTime = signature.getMethod().getAnnotation(Cache.class).cacheSeconds();

        String name = joinPoint.getSignature().getName();

        Object cacheValue = redisTemplate.opsForValue().get(name);

        if (cacheValue != null) {
            return cacheValue;
        } else {
            Object realValue = joinPoint.proceed();
            redisTemplate.opsForValue().set(name, realValue);
            redisTemplate.opsForValue().set(name, realValue, expireTime, TimeUnit.SECONDS);
            return realValue;
        }
    }
}
