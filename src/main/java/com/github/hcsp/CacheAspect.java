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
public class CacheAspect {
    @Autowired
    private RedisTemplate<String, List<RankItem>> redisTemplate;

    @Around("@annotation(com.github.hcsp.anno.Cache)")
    public List<RankItem> cache(ProceedingJoinPoint joinPoint) throws Throwable {
        List<RankItem> cachedItems = redisTemplate.opsForValue().get("items");
        redisTemplate.expire("items", 1, TimeUnit.SECONDS);
        if (cachedItems != null) {
            System.out.println("get from cache");
            return cachedItems;
        } else {
            List<RankItem> res = (List<RankItem>) joinPoint.proceed();
            System.out.println("get from database");
            redisTemplate.opsForValue().set("items", res);
            return res;
        }
    }
}
