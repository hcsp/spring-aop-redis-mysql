package com.github.hcsp.dao.Impl;

import com.github.hcsp.dao.RankDao;
import com.github.hcsp.entity.RankItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankDaoImpl implements RankDao {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<RankItem> getRank() {
        return sqlSession.selectList("BlogMapper.selectForm");
    }
}
