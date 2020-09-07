package com.github.hcsp.Dao;

import java.util.List;

import com.github.hcsp.Moudle.RankItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsRankDaoImpl implements goodsRankDao {
    @Autowired
    SqlSession sqlSession;
    @Override
    public List<RankItem> getGoodsRank() {
        return sqlSession.selectList("db.mybatis.mapper.rankItemsMapper.getRank");
    }
}
