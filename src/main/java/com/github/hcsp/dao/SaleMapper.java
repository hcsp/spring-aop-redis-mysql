package com.github.hcsp.dao;

import com.github.hcsp.entity.SalesRank;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SaleMapper {

    @Autowired
    SqlSession sqlSession;

    public List<SalesRank> getSalesRank() {
        return sqlSession.selectList("com.github.hcsp.Application.goodsOrderBySales");
    }
}
