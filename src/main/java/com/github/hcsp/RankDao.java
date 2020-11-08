package com.github.hcsp;

import com.github.hcsp.entity.RankItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankDao {

    @Autowired
    private SqlSession sqlSession;

    public List<RankItem> getRankItems() {
        return sqlSession.selectList("com.github.hcsp.RankMapper.queryRankItems");
    }
}
