package com.github.hcsp;

import com.github.hcsp.entity.RankItem;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Aspect
@Configuration
public class RankServiceAspect {
    @Autowired
    RedisTemplate redisTemplate;

    Instant start ;
    Instant end ;
    List<RankItem> list;

    @Around("@annotation(com.github.hcsp.anno.Cache)")

    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        start=Instant.now();
        String methodName = joinPoint.getSignature().getName();
        if (redisTemplate.opsForValue().get(methodName) != null && end!=null &&
                Duration.between(end,start).toMillis()<1000) {
            System.out.println("Get result from cache");
            list = (List) redisTemplate.opsForValue().get(methodName);
        } else {
            System.out.println("Get result from database");
            list = (List) joinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, list);
        }
        end=Instant.now();
        return list;
    }
}
