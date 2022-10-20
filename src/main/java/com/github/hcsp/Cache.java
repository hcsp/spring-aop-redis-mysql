package com.github.hcsp;

import com.github.hcsp.entity.RankItem;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class Cache {
    @Autowired
    private RedisTemplate<String, List<RankItem>> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        List<RankItem> value = redisTemplate.opsForValue().get("rank");

        if (value == null) {
            value = (List<RankItem>) joinPoint.proceed();
            redisTemplate.opsForValue().set("rank", value, 1, TimeUnit.SECONDS);
        }

        return value;
    }
}
