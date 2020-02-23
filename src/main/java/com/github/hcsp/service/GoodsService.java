package com.github.hcsp.service;

import com.github.hcsp.dao.GoodsDao;
import com.github.hcsp.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    public List<Goods> getGoodsList(){
        return goodsDao.getGoodsList();
    }
}
