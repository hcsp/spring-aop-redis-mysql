package com.github.hcsp.AOP;

import com.github.hcsp.Order;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;

@Aspect
@Component
public class CacheAop {
    private final RedisTemplate<String, Object> redisTemplate;

    public CacheAop(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.github.hcsp.AOP.Cache)")
    public Object cacheAop(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        CacheValue cachedValue = (CacheValue) redisTemplate.opsForValue().get(methodName);
        if (cachedValue != null) {
            System.out.println("getFormCache");
            long oldTime = cachedValue.getExpired();
            if (System.currentTimeMillis() - oldTime < 1000) {
                System.out.println("from cache");
                return cachedValue.getValue();
            }
            System.out.println("cache expired");
        }
        @SuppressWarnings("unchecked")
        List<Order> value = (List<Order>) joinPoint.proceed();
        System.out.println(value.size());
        System.out.println("store cache");
        CacheValue cacheValue = new CacheValue(System.currentTimeMillis(), value);
        redisTemplate.opsForValue().set(methodName, cacheValue);
        return value;
    }
}
