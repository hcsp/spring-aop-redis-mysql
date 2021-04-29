package com.github.hcsp.config;

import com.github.hcsp.entity.cacheMapValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConfig {
    @Bean
    RedisTemplate<String, cacheMapValue> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, cacheMapValue> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        return template;

    }
}
