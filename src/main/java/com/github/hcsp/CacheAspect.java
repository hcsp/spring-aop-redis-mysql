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
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        long expireTime = signature.getMethod().getAnnotation(Cache.class).cacheSeconds();

        String methodName = signature.getName();
        Object cacheValue = redisTemplate.opsForValue().get(methodName);

        if (cacheValue != null) {
            System.out.println("Get value from cache!");
            return cacheValue;
        } else {
            System.out.println("Get value from database");
            Object realValue = joinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, realValue, expireTime, TimeUnit.SECONDS);
            return realValue;
        }
    }
}
