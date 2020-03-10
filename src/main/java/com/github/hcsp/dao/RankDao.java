package com.github.hcsp.dao;

import com.github.hcsp.entity.RankItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RankDao {
    @Autowired
    private SqlSession sqlSession;

    public List<RankItem> getRank() {
        return sqlSession.selectList("Mapper.selectRank");
    }
}