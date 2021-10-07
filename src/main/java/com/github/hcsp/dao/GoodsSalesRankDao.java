package com.github.hcsp.dao;

import com.github.hcsp.entity.GoodsSalesRankItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsSalesRankDao {
    private final SqlSession sqlSession;

    public GoodsSalesRankDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<GoodsSalesRankItem> getGoodsSalesRank() {
        return this.sqlSession.selectList("selectGoodsSalesRank");
    }
}
