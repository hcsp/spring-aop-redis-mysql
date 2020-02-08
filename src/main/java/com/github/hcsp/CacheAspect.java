package com.github.hcsp;

import com.github.hcsp.anno.Cache;
import jdk.internal.org.objectweb.asm.commons.Method;
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
    RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        long validTime = signature.getMethod().getAnnotation(Cache.class).cacheSeconds();
        String methodName = signature.getName();
        Object cachedValue = redisTemplate.opsForValue().get(methodName);
        if (cachedValue != null) {
            return cachedValue;
        } else {
            try {
                Object realValue = joinPoint.proceed();
                redisTemplate.opsForValue().set(methodName, realValue, validTime, TimeUnit.SECONDS);
                return realValue;
            } catch (Throwable throwable) {
                throw new RuntimeException(throwable);
            }
        }
    }
}
