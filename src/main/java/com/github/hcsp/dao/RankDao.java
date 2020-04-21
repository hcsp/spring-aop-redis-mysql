package com.github.hcsp.dao;

import com.github.hcsp.entity.Rank;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankDao {

    private final SqlSession sqlSession;

    @Autowired
    public RankDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Rank> getGoodsRank() {
        return sqlSession.selectList("MyMapper.selectGoodsRank");
    }
}
