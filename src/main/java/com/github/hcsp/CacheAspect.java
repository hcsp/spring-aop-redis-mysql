package com.github.hcsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhaofeng Zhou
 * @date 2021/8/3/003 22:48
 */
@Aspect
@Configuration
public class CacheAspect {
    Map<String, Object> cache = new HashMap<>();

    @Around("@annotation(com.github.hcsp.annotation.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();

        Object cacheValue = cache.get(methodName);

        if (cacheValue != null) {
            System.out.println("get data from cache");
            return cacheValue;
        } else {
            System.out.println("get data from database");
            Object realValue = joinPoint.proceed();
            cache.put(methodName, realValue);
            return realValue;
        }

    }
}
