package com.github.hcsp.config;

import com.github.hcsp.entity.CacheKey;
import com.github.hcsp.entity.CacheValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class ApplicationConfig {
    @Bean
    RedisTemplate<CacheKey, CacheValue> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<CacheKey, CacheValue> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
