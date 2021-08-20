package com.github.hcsp;

import com.github.hcsp.entity.CacheKey;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Configuration
public class CacheAspect {
    Map<CacheKey, Object> cache = new HashMap<>();

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        Object[] args = proceedingJoinPoint.getArgs();
        Object caller = proceedingJoinPoint.getThis();
        CacheKey cacheKey = new CacheKey(methodName, args, caller);

        Object cacheValue = cache.get(cacheKey);

        if(cacheValue != null) {
            System.out.println("cache");
            return cacheValue;
        } else {
            System.out.println("database");
            Object realValue = proceedingJoinPoint.proceed();
            cache.put(cacheKey, realValue);
            return realValue;
        }
    }
}
