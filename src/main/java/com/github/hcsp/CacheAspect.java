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
    private static final int CACHE_TIME = 1000; // 1s
    private static long processTime;

    public static void setProcessTime() {
        processTime = System.currentTimeMillis();
    }

    public static long getProcessTime() {
        return processTime;
    }

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cacheAop(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        Object cacheValue = redisTemplate.opsForValue().get(methodName);
        if (cacheValue != null) {
            // 缓存是否过期
            if (System.currentTimeMillis() - getProcessTime() > CACHE_TIME) {
                return getDataFromDatabase(joinPoint, methodName);
            } else {
                System.out.println("get data from cache");
                setProcessTime();
                return cacheValue;
            }
        } else {
            return getDataFromDatabase(joinPoint, methodName);
        }
    }

    private Object getDataFromDatabase(ProceedingJoinPoint joinPoint, String methodName) throws Throwable {
        System.out.println("get data from database");
        Object result = joinPoint.proceed();
        redisTemplate.opsForValue().set(methodName, result);
        setProcessTime();
        return result;
    }

}

