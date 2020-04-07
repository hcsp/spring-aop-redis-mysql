package com.github.hcsp;

import com.github.hcsp.entity.RankItem;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@Aspect
@Configuration
public class RankServiceAspect {
    @Autowired
    RedisTemplate redisTemplate;


    List<RankItem> list;

    @Around("@annotation(com.github.hcsp.anno.Cache)")

    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        if (redisTemplate.opsForValue().get(methodName) != null) {
            System.out.println("Get result from cache");
            list = (List) redisTemplate.opsForValue().get(methodName);
        } else {
            list = (List) joinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, list);
        }
        return list;
    }
}
