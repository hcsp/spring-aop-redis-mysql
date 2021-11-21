package com.github.hcsp.dao;

import com.github.hcsp.entity.Rank;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankDao {
    private final SqlSession sqlSession;

    public RankDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Rank> selectRank() {
        return sqlSession.selectList("MyMapper.selectRank");
    }

}
