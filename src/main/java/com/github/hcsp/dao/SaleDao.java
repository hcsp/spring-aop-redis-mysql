package com.github.hcsp.dao;

import com.github.hcsp.annotation.MyCache;
import com.github.hcsp.entity.Money;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleDao {
    @Autowired
    private SqlSession sqlSession;

    @MyCache
    public List<Money> getSale() {
        return sqlSession.selectList("mapper.selectSale");
    }
}
