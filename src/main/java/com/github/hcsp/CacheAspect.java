/**
 *
 */
package com.github.hcsp;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author sunp
 *
 */
@Aspect
@Configuration
public class CacheAspect {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.annotation.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        Object cacheValue = redisTemplate.opsForValue().get(methodName);
        if (cacheValue != null) {
            return cacheValue;
        } else {
            Object realValue = joinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, realValue, 1, TimeUnit.SECONDS);
            return realValue;
        }

    }

}
