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
    private final Map<CacheKey, CacheValue> cache = new HashMap<>();

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = signature.getName();
        Object[] args = proceedingJoinPoint.getArgs();
        Object caller = proceedingJoinPoint.getThis();

        CacheKey cacheKey = new CacheKey(methodName, args, caller);
        CacheValue cacheValue = cache.get(cacheKey);

        int cacheDuration = signature.getMethod().getAnnotation(Cache.class).value();

        if (cacheValue != null && Instant.now().getNano() - cacheValue.getCacheTime().getNano() < cacheDuration * 1000) {
            return cacheValue.getValue();
        } else {
            Object realValue = proceedingJoinPoint.proceed();
            cache.put(cacheKey, new CacheValue(Instant.now(), realValue));
            return realValue;
        }
    }
}
