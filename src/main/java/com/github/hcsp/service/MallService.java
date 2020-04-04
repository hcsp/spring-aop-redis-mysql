package com.github.hcsp.service;

import com.github.hcsp.annotation.Cache;
import com.github.hcsp.dao.MallDao;
import com.github.hcsp.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallService {
    private MallDao mallDao;

    @Autowired
    public MallService(MallDao mallMapper, RedisTemplate redisTemplate) {
        this.mallDao = mallMapper;
    }

    @Cache
    public List<Goods> getSortedGoods() {
        return mallDao.getSortedGoods();
    }
}
