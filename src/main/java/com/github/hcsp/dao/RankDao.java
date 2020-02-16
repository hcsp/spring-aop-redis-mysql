package com.github.hcsp.dao;

import com.github.hcsp.entity.Rank;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankDao {

    @Autowired
    private SqlSession sqlSession;

    public List<Rank> getRankList(){
        return sqlSession.selectList("com.github.hcsp.RankMapper.selectRank");
    }
}
