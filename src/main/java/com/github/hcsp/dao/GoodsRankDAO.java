package com.github.hcsp.dao;

import com.github.hcsp.entity.Goods;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class GoodsRankDAO {
    private final SqlSession sqlSession;

    @Inject
    public GoodsRankDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Goods> getGoodsAndSortByPrice(){
        return sqlSession.selectList("goodsRank");
    }
}
