package com.github.hcsp.dao;

import com.github.hcsp.entity.OrderRankItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDao {
    @Autowired
    SqlSession sqlSession;

    public List<OrderRankItem> getOrderRanks() {
        return sqlSession.selectList("OrderMapper.selectOrderRank");
    }
}
