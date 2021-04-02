package com.github.hcsp;

import com.github.hcsp.entity.RankItem;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheTemplate {
    @Bean
    public RedisTemplate<String, List<RankItem>> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, List<RankItem>> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}

