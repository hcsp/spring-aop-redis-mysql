package com.github.hcsp.aop;

import com.github.hcsp.annotation.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.lang.reflect.Method;

@Configuration
@Aspect
public class CacheInterceptor {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.annotation.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // 这里不严谨, 仅用方法名当做缓存key
        String cacheKey = method.getName();
        CacheValue cacheValue = (CacheValue) redisTemplate.opsForValue().get(cacheKey);
        // 判断缓存是否存在
        if (cacheValue != null) { // 缓存已存在判断缓存时间是否过期

            if (isCacheExpiration(cacheValue, method)) { // 缓存时间已过期
                return invokeRealMethodThenPutIntoCache(joinPoint, cacheKey);
            } else { // 未过期直接从redis中返回结果
                System.out.println("get data from cache");
                CacheValue value = (CacheValue) redisTemplate.opsForValue().get(cacheKey);
                if (value != null) {
                    return value.getValue();
                } else {
                    return null;
                }
            }

        } else {
            return invokeRealMethodThenPutIntoCache(joinPoint, cacheKey);
        }

    }

    private Object invokeRealMethodThenPutIntoCache(ProceedingJoinPoint joinPoint, String cacheKey) throws Throwable {
        System.out.println("get data from db");
        Object realInvokeMethodVal = joinPoint.proceed();
        CacheValue value = new CacheValue(System.currentTimeMillis(), realInvokeMethodVal);
        redisTemplate.opsForValue().set(cacheKey, value);
        return realInvokeMethodVal;
    }

    private boolean isCacheExpiration(CacheValue cacheValue, Method method) {
        long dataTime = cacheValue.getTime();
        int cacheSeconds = method.getAnnotation(Cache.class).seconds();
        return (System.currentTimeMillis() - dataTime) > cacheSeconds * 1000L;
    }

    private static class CacheValue implements Serializable {
        private Long time; // 时间戳, 用于判断缓存时间
        private Object value; // 存储实际方法调用结果

        CacheValue(Long time, Object value) {
            this.time = time;
            this.value = value;
        }

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
