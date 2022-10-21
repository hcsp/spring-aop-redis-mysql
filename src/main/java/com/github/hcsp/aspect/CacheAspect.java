package com.github.hcsp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class CacheAspect {
    // 声明该类是与spring有关的拦截类

        @Autowired
         RedisTemplate<String, Object> cache;

        //标注将要拦截的方法
        @Around("@annotation(com.github.hcsp.annotation.Cache)")
        public Object cache(ProceedingJoinPoint joinPoint) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            String methodName = signature.getName();
            Object cachedValue = cache.opsForValue().get(methodName);
            if (cachedValue == null) {
                System.out.println("读取真实数据");
                return getRealData(joinPoint, methodName);
            } else {
                System.out.println("使用缓存");
                return cachedValue;
            }
        }

        private Object getRealData(ProceedingJoinPoint joinPoint, String methodName) {
            try {
                Object realValue = joinPoint.proceed();
                cache.opsForValue().set(methodName, realValue, 1L, TimeUnit.SECONDS);
                return realValue;
            } catch (Throwable throwable) {
                throw new RuntimeException(throwable);
            }
        }
}
