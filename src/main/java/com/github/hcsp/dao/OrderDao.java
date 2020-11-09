package com.github.hcsp.dao;

import java.util.List;

import com.github.hcsp.entity.Order;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDao {
    @Autowired
    private SqlSession sqlSession;

    public List<Order> getGoodsRankByDesc() {
        return  sqlSession.selectList("com.github.hcsp.OrderDao.getGoodsRankByDesc");
    }
}
