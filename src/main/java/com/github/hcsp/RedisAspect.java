package com.github.hcsp;

import com.github.hcsp.entity.RedisKey;
import com.github.hcsp.entity.RedisValue;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Aspect
@Configuration
public class RedisAspect {
    private final RedisTemplate<Object, Object> redisTemplate;

    public RedisAspect(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.github.hcsp.annotation.Redis)")
    public Object redis(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        RedisKey redisKey = new RedisKey(proceedingJoinPoint.getSignature().getName());
        RedisValue redisValue = (RedisValue) redisTemplate.opsForValue().get(redisKey);

        if (redisValue != null) {
            if (System.currentTimeMillis() - redisValue.getTime() > 1000) {
                return addValueToRedis(proceedingJoinPoint, redisKey);
            }
            System.out.println("redis...");
            return redisValue.getValue();
        }
        return addValueToRedis(proceedingJoinPoint, redisKey);
    }

    private Object addValueToRedis(ProceedingJoinPoint proceedingJoinPoint, RedisKey redisKey) throws Throwable {
        RedisValue newValue = new RedisValue(proceedingJoinPoint.proceed(), System.currentTimeMillis());
        redisTemplate.opsForValue().set(redisKey, newValue);
        return newValue.getValue();
    }
}
