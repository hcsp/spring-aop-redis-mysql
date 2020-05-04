package com.github.hcsp;

import com.github.hcsp.entity.Rank;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@Aspect
public class AspectCache {

    @Autowired
    private RedisTemplate<String, Object> template;

    @Around("@annotation(com.github.hcsp.annotation.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        final Signature signature = joinPoint.getSignature();
        final String name = signature.getName();
        final ValueOperations valueOperations = template.opsForValue();
        Object resultCached = valueOperations.get(name);
        if (resultCached != null) {
            return resultCached;
        } else {
            final List<Rank> realResult = (List<Rank>) joinPoint.proceed();
            valueOperations.set(name, realResult, 1_000_000, TimeUnit.MICROSECONDS);
            return realResult;
        }
    }
}
