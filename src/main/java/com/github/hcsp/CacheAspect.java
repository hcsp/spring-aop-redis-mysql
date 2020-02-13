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
    private RedisTemplate<String, Object> template;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        String signature = joinPoint.getSignature().toString();
        Long cachedTime = (Long) template.opsForHash().get(signature, "cachedTime");
        Object cachedValue = template.opsForHash().get(signature, "cachedValue");
        if (cachedTime != null && System.currentTimeMillis() - cachedTime <= 1000) {
            System.out.println("return in cache");
            return cachedValue;
        } else {
            System.out.println("return new value");
            Object newValue = joinPoint.proceed();
            template.opsForHash().put(signature, "cachedTime", System.currentTimeMillis());
            template.opsForHash().put(signature, "cachedValue", newValue);
            return newValue;
        }
    }
}
