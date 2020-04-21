package com.github.hcsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class RedisCacheAspect {
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public RedisCacheAspect(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        Object value = redisTemplate.opsForValue().get(name);
        if (value != null) {
            System.out.println("命中🎯 Redis 缓存");
            return value;
        }

        System.out.println("没有 Redis 缓存或缓存过期");
        value = joinPoint.proceed();
        redisTemplate.opsForValue().set(name, value, 1L, TimeUnit.SECONDS);
        return value;
    }
}
