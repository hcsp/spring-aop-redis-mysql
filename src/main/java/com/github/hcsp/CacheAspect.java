package com.github.hcsp;

import com.github.hcsp.anno.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Author: YangHuiQuan
 * @Description:
 * @Date: 2020/8/19 20:52
 * @version: 1.0
 * @since: JDK 8
 */
@Aspect
@Configuration
public class CacheAspect {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public CacheAspect(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        Object value = redisTemplate.opsForValue().get(name);
        if (value != null) {
            System.out.println("缓存中取出");
            return value;
        }

        System.out.println("缓存过期");
        value = joinPoint.proceed();
        redisTemplate.opsForValue().set(name, value);
        int timeout = signature.getMethod().getAnnotation(Cache.class).timeout();
        redisTemplate.expire(name, timeout, TimeUnit.SECONDS);
        return value;
    }

}


