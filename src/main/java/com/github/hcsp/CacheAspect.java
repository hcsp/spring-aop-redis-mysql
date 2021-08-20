package com.github.hcsp;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.entity.CacheKey;
import com.github.hcsp.entity.CacheValue;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Configuration
public class CacheAspect {
    Map<CacheKey, CacheValue> cache = new HashMap<>();

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Cache cacheAnnotation = methodSignature.getMethod().getAnnotation(Cache.class);
        String methodName = methodSignature.getName();
        Object[] args = proceedingJoinPoint.getArgs();
        Object caller = proceedingJoinPoint.getThis();
        CacheKey cacheKey = new CacheKey(methodName, args, caller);

        CacheValue cacheValue = cache.get(cacheKey);
        int cacheDuration = cacheAnnotation.value();
        Instant currentInstant = Instant.now();
        if (cacheValue != null && currentInstant.getNano() - cacheValue.getCacheTime().getNano() < cacheDuration * 1000) {
            System.out.println("cache");
            return cacheValue.getValue();
        } else {
            System.out.println("database");
            Object realValue = proceedingJoinPoint.proceed();
            cache.put(cacheKey, new CacheValue(realValue, currentInstant));
            return realValue;
        }
    }
}
