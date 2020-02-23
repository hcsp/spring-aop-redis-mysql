package com.github.hcsp.dao;

import com.github.hcsp.entity.Goods;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsDao {
    @Autowired
    private SqlSession sqlSession;

    public List<Goods> getGoodsList(){
        return sqlSession.selectList("com.github.hcsp.GoodsMapper.selectGoods");
    }
}
