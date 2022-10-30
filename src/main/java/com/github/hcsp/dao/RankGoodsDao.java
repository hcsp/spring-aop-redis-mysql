package com.github.hcsp.dao;

import com.github.hcsp.entity.GoodsSaleRankItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankGoodsDao {
    @Autowired
    private SqlSession sqlSession;

    public List<GoodsSaleRankItem> doRankGoods() {
        return sqlSession.selectList("RankMapper.selectProductRank");
    }
}
