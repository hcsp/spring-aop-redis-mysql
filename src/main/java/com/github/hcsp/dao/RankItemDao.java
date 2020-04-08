package com.github.hcsp.dao;

import com.github.hcsp.entity.RankItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankItemDao {
    @Autowired
    SqlSession sqlSession;

    public List getRankItem() {
        List<RankItem> list;
        list = sqlSession.selectList("db.mybatis.myMapper.returnRankItem");
        return list;
    }
}
