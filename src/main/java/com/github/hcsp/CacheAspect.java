package com.github.hcsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;


@Aspect
@Configuration
public class CacheAspect {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("运行正常！");
        //得到目标方法的签名
        Signature signature = proceedingJoinPoint.getSignature();
        String methodName = signature.getName();

        Object result = redisTemplate.opsForValue().get(methodName);
        if (result == null) {
            System.out.println("第一次查询");
            result = proceedingJoinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, result, 1L, TimeUnit.SECONDS);

            System.out.println();
            return result;
        }
        System.out.println("没有再查");
        return result;
    }
}
