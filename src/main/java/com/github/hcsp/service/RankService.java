package com.github.hcsp.service;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.dao.GoodsMapper;
import com.github.hcsp.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Cache
    public List<Goods> getRank(){
        return goodsMapper.getAll();
    }
}
