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
    SqlSession sqlSession;

    @Cache
    public List<RankItem> selectRank(){
        return sqlSession.selectList("MyMapper.selectRank");
    }
}
