package com.github.hcsp;

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
    private RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint point) throws Throwable {
        final MethodSignature method = (MethodSignature) point.getSignature();
        final String methodName = method.getName();
        final Object cacheValue = redisTemplate.opsForValue().get(methodName);
        if (cacheValue == null) {
            System.out.println("Get value from database!");
            Object realValue = point.proceed();
            redisTemplate.opsForValue().set(methodName, realValue);
            return realValue;
        } else {
            System.out.println("Get value from cache!");
            return cacheValue;
        }
    }
}
