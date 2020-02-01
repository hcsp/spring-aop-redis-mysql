package com.github.hcsp;

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
    Map<String, Object> cache = new HashMap<>();
    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
        String methodName = signature.getName();

        Object cachedValue = cache.get(methodName);
        if(cachedValue != null){
            return cachedValue;
        }
        Object realVal =proceedingJoinPoint.proceed();
        cache.put(methodName, realVal);
        return realVal;
    }
}
