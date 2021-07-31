package com.github.hcsp.dao;

import com.github.hcsp.entity.GoodsRank;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankDao {
    @Autowired
    SqlSession sqlSession;

    public List<GoodsRank> getRank() {
        return sqlSession.selectList("RankMapper.selectRank");
    }
}
