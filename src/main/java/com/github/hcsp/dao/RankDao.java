package com.github.hcsp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.hcsp.entity.RankItem;

import java.util.List;

@Service
public class RankDao {

    @Autowired
    private SqlSession sqlSession;

    public List<RankItem> getRank() {
        return sqlSession.selectList("MyMapper.selectRank");
    }
}
