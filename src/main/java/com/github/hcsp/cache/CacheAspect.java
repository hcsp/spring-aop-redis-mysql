package com.github.hcsp.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CacheAspect {

  private static final int CACHE_TIME = 1000;

  @Autowired
  RedisTemplate<String, Object> redisTemplate;

  @Around("@annotation(com.github.hcsp.cache.Cache)")
  public Object cacheAop(ProceedingJoinPoint joinPoint) throws Throwable {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    String methodName = signature.getName();
    CacheValue cacheValue = (CacheValue) redisTemplate.opsForValue().get(methodName);
    if (cacheValue != null) {
      if (System.currentTimeMillis() - cacheValue.getProcessTime() > CACHE_TIME) {
        System.out.println("缓存过期，重新放入");
        Object result = joinPoint.proceed();
        redisTemplate.opsForValue()
            .set(methodName, new CacheValue(result, System.currentTimeMillis()));
        return result;
      } else {
        System.out.println("返回缓存");
        return cacheValue.getResult();
      }
    } else {
      System.out.println("无缓存，执行真正的方法");
      Object result = joinPoint.proceed();
      redisTemplate.opsForValue()
          .set(methodName, new CacheValue(result, System.currentTimeMillis()));
      return result;
    }
  }
}