package com.github.hcsp.config;

import com.github.hcsp.entity.RankItem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    RedisTemplate<String, List<RankItem>> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, List<RankItem>> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }
}
