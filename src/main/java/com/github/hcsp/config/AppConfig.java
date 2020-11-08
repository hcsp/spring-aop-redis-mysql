package com.github.hcsp.config;

import com.github.hcsp.CacheItem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConfig {
    @Bean
    RedisTemplate<String, CacheItem> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, CacheItem> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
