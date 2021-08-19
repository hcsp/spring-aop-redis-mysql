package com.github.hcsp.dao;

import com.github.hcsp.entity.GoodsSales;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsSalesDao {
    private final SqlSession sqlSession;

    public GoodsSalesDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<GoodsSales> getGoodsSalesList() {
        return this.sqlSession.selectList("selectGoodsSalesList");
    }
}
