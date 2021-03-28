package com.github.hcsp.dao;

import com.github.hcsp.annotations.Cache;
import com.github.hcsp.entities.RankItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class RankOrderDao {
    @Resource
    private SqlSession sqlSession;

    @Cache
    public List<RankItem> doRankOrder() {
        return sqlSession.selectList("Mapper.selectOrderRank");
    }
}
