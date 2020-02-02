package com.github.hcsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Aspect
@Configuration
public class CacheAspect {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
        String name = signature.getName();
        Object cacheValue = redisTemplate.opsForValue().get(name);
        if(cacheValue!=null){
            System.out.println("get from Cache");
            return cacheValue;
        }else {
            System.out.println("get from Database");
            Object realValue = proceedingJoinPoint.proceed();
            redisTemplate.opsForValue().set(name,realValue);
            return realValue;
        }
    }
}
