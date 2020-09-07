package com.github.hcsp;

import java.util.concurrent.TimeUnit;

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
    Long timeout = 1L;
    //  Map<String, Object> cache = new HashMap<>();
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature(); //获得方法名
        String methodName = signature.getName();
        Object cacheValue = redisTemplate.opsForValue().get(methodName);
        if (cacheValue != null) {
            System.out.println("Get value from cache");
            return cacheValue;
        } else {
            Object realValue = joinPoint.proceed();  //执行
            redisTemplate.opsForValue().set(methodName, realValue, timeout, TimeUnit.SECONDS);
            System.out.println("Get value from database.");
            return realValue;
        }
    }
}
