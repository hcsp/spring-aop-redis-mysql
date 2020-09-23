package com.github.hcsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CacheAspect {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    // 只要标注了cache的,就拦截
    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        // 拿到方法名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        // 拿到缓存的值
        Object cacheValue = redisTemplate.opsForValue().get(methodName);
        Long currentTime = (Long) redisTemplate.opsForValue().get("currentTime");
        System.out.println(currentTime);
        if (cacheValue != null && currentTime != null) {
            // 判断缓存是否过期
            if (System.currentTimeMillis() - currentTime > 1000) {
                System.out.println("get value from database");
                Object realValue = joinPoint.proceed();
                // 当前时间也要存
                redisTemplate.opsForValue().set("currentTime", System.currentTimeMillis());
                // 存值
                redisTemplate.opsForValue().set(methodName, realValue);
                return realValue;
            } else {
                System.out.println("get value from cache");
                return cacheValue;
            }
        } else {
            Object realValue = joinPoint.proceed();
            redisTemplate.opsForValue().set("currentTime", System.currentTimeMillis());
            redisTemplate.opsForValue().set(methodName, realValue);
            System.out.println("get value from database");
            return realValue;
        }
    }
}


