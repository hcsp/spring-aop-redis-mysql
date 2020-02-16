package com.github.hcsp.dao;

import com.github.hcsp.entity.Order;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDao {
    @Autowired
    private SqlSession sqlSession;

    public List<Order> getOrderList(){
        return sqlSession.selectList("com.github.hcsp.OrderMapper.selectOrder");
    }
}
