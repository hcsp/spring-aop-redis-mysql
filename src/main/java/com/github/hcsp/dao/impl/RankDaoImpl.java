package com.github.hcsp.dao.impl;

import com.github.hcsp.dao.RankDao;
import com.github.hcsp.entity.RankItem;
import com.github.hcsp.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Mapper
@Service
public class RankDaoImpl implements RankDao {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public User getUserById(@Param("id") Integer id) {
        return null;
    }

    @Override
    public List<RankItem> getRank() {
        return sqlSession.selectList("RankMapper.selectRank");
    }
}
