package com.github.hcsp.advisor;

import com.github.hcsp.entity.GoodsDealInfo;
import com.github.hcsp.myAnnotation.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

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
    private long lastMilliTime = 0;

    @Around("@annotation(com.github.hcsp.myAnnotation.Cache)")
    private List<GoodsDealInfo> checkCacheBeforeFetchFromDataBase(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        List<GoodsDealInfo> model;
        if (isValidCacheTime(pjp)) {
            System.out.println("走缓存");
            HashOperations<String, String, List<GoodsDealInfo>> res = redisTemplate.opsForHash();
            model = res.get(methodName, "map");
        } else {
            System.out.println("走数据库");
            model = (List<GoodsDealInfo>) pjp.proceed();
            redisTemplate.opsForHash().put(methodName, "map", model);
        }
        return model;
    }

    private boolean isValidCacheTime(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        long validCacheTime = method.getAnnotation(Cache.class).value();
        long currentTimeMillis = System.currentTimeMillis();
        long duration = currentTimeMillis - lastMilliTime;
        boolean flag = duration <= (validCacheTime * 1000);
        lastMilliTime = currentTimeMillis;
        return flag;
    }
}
