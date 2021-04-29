package com.github.hcsp.Dao;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.entity.Goods;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RankDao {
    private final SqlSession sqlSession;

    @Inject
    public RankDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Cache()
    public List<Goods> getRank() {
        return sqlSession.selectList("myMapper.getRank");
    }
}
