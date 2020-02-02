package com.github.hcsp;

import com.github.hcsp.anno.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Aspect
@Configuration
public class CacheAspect {
    static class CacheValue implements Serializable {
        @NotNull Object rankItemCache;
        @NotNull long time;
        public CacheValue(Object rankItemCache, long time) {
            this.rankItemCache = rankItemCache;
            this.time = time;
        }
    }
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
        String name = signature.getName();
        int myTime = signature.getMethod().getAnnotation(Cache.class).cacheSeconds();
        CacheValue cacheValue = (CacheValue) redisTemplate.opsForValue().get(name);
        if(cacheValue!=null&&(System.currentTimeMillis()-cacheValue.time)<myTime*1000){
            System.out.println("get from Cache");
            return cacheValue.rankItemCache;
        }else {
            System.out.println("get from Database");
            Object realValue = proceedingJoinPoint.proceed();
            CacheValue myCacheValue = new CacheValue(realValue,System.currentTimeMillis());
            redisTemplate.opsForValue().set(name,myCacheValue);
            return realValue;
        }
    }
}
