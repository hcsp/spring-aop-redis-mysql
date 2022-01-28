package com.github.hcsp.config;

import com.github.hcsp.dao.RankDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean
    public RankDao getRankDao() {
        return null;
    }
}
