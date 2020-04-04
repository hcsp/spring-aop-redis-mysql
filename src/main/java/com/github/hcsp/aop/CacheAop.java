package com.github.hcsp.aop;

import com.github.hcsp.entity.Goods;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class CacheAop {
    @Autowired
    private RedisTemplate redisTemplate;


    @Around("@annotation(com.github.hcsp.annotation.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        final Signature signature = joinPoint.getSignature();
        final String name = signature.getName();
        final ValueOperations valueOperations = redisTemplate.opsForValue();
        Object resultCached = valueOperations.get(name);
        if (resultCached != null) {
            return resultCached;
        } else {
            final List<Goods> realResult = (List<Goods>) joinPoint.proceed();
            valueOperations.set(name, realResult, 1_000_000, TimeUnit.MICROSECONDS);
            return realResult;
        }
    }
}
