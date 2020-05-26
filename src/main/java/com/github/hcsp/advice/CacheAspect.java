package com.github.hcsp.advice;

import com.github.hcsp.RedisUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Author: GoFocus
 * @Date: 2020-05-26 14:59
 * @Description:
 */

@Aspect
@Configuration
public class CacheAspect {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object cachedValue = redisUtils.get(methodName);
        if (cachedValue != null) {
            System.out.println("get value from cache");
            return cachedValue;
        } else {
            System.out.println("get value from database");
            Object value = joinPoint.proceed();
            redisUtils.set(methodName, value);
            redisTemplate.expire(methodName, 1, TimeUnit.SECONDS);
            return value;
        }


    }
}
