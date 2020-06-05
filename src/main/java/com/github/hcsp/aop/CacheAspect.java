package com.github.hcsp.aop;

import com.github.hcsp.anno.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;

@Aspect
@Configuration
public class CacheAspect {

    private static class CacheValue implements Serializable {
        private final Object value;
        private final long time;

        private CacheValue(Object value, long time) {
            this.value = value;
            this.time = time;
        }
    }

    @Resource
    RedisTemplate<String, CacheValue> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String cachedKey = signature.getName();
        int cacheSeconds = signature.getMethod().getAnnotation(Cache.class).value(); // 用户设定的缓存有效期
        CacheValue cachedValue = redisTemplate.opsForValue().get(cachedKey);

        if (cachedValue != null) {
            if (isCacheExpires(cachedValue, cacheSeconds)) {
                return proceedAndSetCache(joinPoint, cachedKey);
            } else {
                System.out.println("Get value from cache: " + cachedValue.value);
                return cachedValue.value;
            }
        } else {
            return proceedAndSetCache(joinPoint, cachedKey);
        }
    }

    private boolean isCacheExpires(CacheValue cachedValue, int cacheSeconds) {
        return System.currentTimeMillis() - cachedValue.time > cacheSeconds * 1000;
    }

    private Object proceedAndSetCache(ProceedingJoinPoint joinPoint, String cachedKey) throws Throwable {
        Object realValue = joinPoint.proceed();
        redisTemplate.opsForValue().set(cachedKey, new CacheValue(realValue, System.currentTimeMillis()));
        System.out.println("Get value from database: " + realValue);
        return realValue;
    }
}
