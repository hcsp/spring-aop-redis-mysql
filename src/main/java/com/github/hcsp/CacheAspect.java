package com.github.hcsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

public class CacheAspect {
    Map<String,Object> cache = new HashMap<>();
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
}
