package com.github.hcsp.dao;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.entity.RankItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankDao {

    @Autowired
    private SqlSession sqlSession;

    @Cache(cacheSeconds = 1)
    public List<RankItem> getRank() {
        return sqlSession.selectList("MyMapper.selectRank");
    }
}
