package com.github.hcsp;

import com.github.hcsp.entity.cacheMapValue;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Aspect
@Configuration
public class CacheAspect {
    @Autowired
    RedisTemplate<String, cacheMapValue> redisTemplate;


//    Map<String, cacheMapValue> cache = new HashMap<>();


    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {

        int cacheTime = joinPoint.getSignature().getModifiers();

        String targetMethodName = joinPoint.getSignature().getName();
        cacheMapValue valueInCache = redisTemplate.opsForValue().get(targetMethodName);

        if (cacheExpires(valueInCache, cacheTime)) {
            System.out.println("come from cache");
            return valueInCache.getValue();
        } else {
            Object realValue = joinPoint.proceed();
            redisTemplate.opsForValue().set(targetMethodName, new cacheMapValue(realValue, System.currentTimeMillis()));

            System.out.println("come from joinPoint Method");
            return realValue;
        }
    }

    private boolean cacheExpires(cacheMapValue cache, int cacheTime) {
        if (cache != null) {
            long createdTime = cache.getCreatedTime();

            return System.currentTimeMillis() - createdTime < cacheTime * 1000;

        }
        return false;
    }
}
