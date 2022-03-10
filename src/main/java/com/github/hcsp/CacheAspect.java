package com.github.hcsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class CacheAspect {
    private final RedisTemplate<String, Object> template;

    @Autowired
    public CacheAspect(RedisTemplate<String, Object> template) {
        this.template = template;
    }

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        Object value = template.opsForValue().get(methodName);

        if (value != null) {
            System.out.println("cache");
            return value;
        }
        System.out.println("real");

        Object result = pjp.proceed();
        template.opsForValue().set(methodName, result, 1L, TimeUnit.SECONDS);
        return result;


    }
}
