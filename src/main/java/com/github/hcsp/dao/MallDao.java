package com.github.hcsp.dao;

import com.github.hcsp.entity.Goods;
import com.github.hcsp.mapper.MallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MallDao {
    private MallMapper mallMapper;

    @Autowired
    public MallDao(MallMapper mallMapper) {
        this.mallMapper = mallMapper;
    }

    public List<Goods> getSortedGoods(){
        return mallMapper.getSortedGoods();
    }
}
