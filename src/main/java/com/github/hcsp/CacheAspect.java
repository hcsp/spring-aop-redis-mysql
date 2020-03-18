package com.github.hcsp;

import com.github.hcsp.anno.Cache;
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
public class CacheAspect {
    @Autowired
    private
    RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        String methodName = signature.getName();

        Object cacheValue = redisTemplate.opsForValue().get(methodName);

        int expireTime = signature.getMethod().getAnnotation(Cache.class).cacheSeconds();

        if (cacheValue != null) {
            System.out.println("get value from cache!");
            return cacheValue;
        } else {
            Object realValue = joinPoint.proceed();
            System.out.println("get value from database!");
            redisTemplate.opsForValue().set(methodName, realValue, expireTime, TimeUnit.SECONDS);
            return realValue;
        }
    }
}
