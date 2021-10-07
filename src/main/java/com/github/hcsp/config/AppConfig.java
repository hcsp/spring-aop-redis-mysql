package com.github.hcsp.config;

import com.github.hcsp.entity.CacheValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RedisTemplate<String, CacheValue> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, CacheValue> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
