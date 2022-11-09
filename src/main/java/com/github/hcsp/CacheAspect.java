package com.github.hcsp;

import com.github.hcsp.anno.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Aspect
@Configuration
public class CacheAspect {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        Object cacheValue = redisTemplate.opsForValue().get(methodName);
        long cacheTime = 0L;
        Object lastTime = redisTemplate.opsForValue().get("cacheTIme");
        if (lastTime != null) {
            cacheTime = (long) lastTime;
        }
        long currentTime = System.currentTimeMillis();
        long duration = signature.getMethod().getAnnotation(Cache.class).value();
        if (cacheValue != null && currentTime - cacheTime < duration) {
            System.out.println("from cache");
            return cacheValue;
        } else {
            System.out.println("method is called");
            Object value = joinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, value);
            redisTemplate.opsForValue().set("cacheTIme", System.currentTimeMillis());
            return value;
        }
    }
}
