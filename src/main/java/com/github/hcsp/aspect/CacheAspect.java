package com.github.hcsp.aspect;

import com.github.hcsp.annotation.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

@Aspect
@Configuration
public class CacheAspect {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    KeyGenerator keyGenerator;

    @Around("@annotation(com.github.hcsp.annotation.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        String cachekey = (String) keyGenerator.generate(
                joinPoint.getTarget(),
                method,
                joinPoint.getArgs());

        Object cacheValue = redisTemplate.opsForHash().get(cachekey, "cachedValue");
        Long cacheTime = (Long) redisTemplate.opsForHash().get(cachekey, "cachedTime");

        if (cacheValue != null && !hasExpired(cacheTime, method)) {
            System.out.println("使用了缓存");
            return cacheValue;
        } else {
            System.out.println("未使用缓存");
            Object value = joinPoint.proceed();
            redisTemplate.opsForHash().put(cachekey, "cachedValue", value);
            redisTemplate.opsForHash().put(cachekey, "cachedTime", System.currentTimeMillis());
            return value;
        }
    }

    private boolean hasExpired(Long cacheTime, Method method) {
        long currTime = System.currentTimeMillis();
        long expiredTime = method.getAnnotation(Cache.class).expiredTime();
        return currTime - cacheTime > 1000 * expiredTime;
    }
}
