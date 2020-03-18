package com.github.hcsp.advisor;

import com.github.hcsp.entity.GoodsDealInfo;
import com.github.hcsp.myAnnotation.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * User: Lzj
 * Date: 2020-03-18
 * Time: 13:33
 */
@Component
@Aspect
public class CacheAdvisor {
    @Autowired
    private RedisTemplate redisTemplate;

    @Around("@annotation(com.github.hcsp.myAnnotation.Cache)")
    private List<GoodsDealInfo> checkCacheBeforeFetchFromDataBase(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        Object model;
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        long validCacheTime = method.getAnnotation(Cache.class).value();
        if (redisTemplate.hasKey(methodName)) {
            System.out.println("走缓存");
            model = redisTemplate.opsForValue().get(methodName);
        } else {
            System.out.println("走数据库");
            model = pjp.proceed();
            redisTemplate.opsForValue().set(methodName, model);
            redisTemplate.expire(methodName, validCacheTime, TimeUnit.SECONDS);
        }
        return (List<GoodsDealInfo>) model;
    }
}
