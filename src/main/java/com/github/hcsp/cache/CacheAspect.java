package com.github.hcsp.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class CacheAspect {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(Cache)")
    public Object cache(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        String methodName = signature.getName();
        Object cacheValue = redisTemplate.opsForValue().get(methodName);
        if(cacheValue != null) {
            return cacheValue;
        } else {
            cacheValue = point.proceed();
            redisTemplate.opsForValue().set(methodName,cacheValue,signature.getMethod().getAnnotation(Cache.class).value(),
                    TimeUnit.SECONDS);
            return cacheValue;
        }
    }

}
