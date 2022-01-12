package com.github.hcsp.Dao;

import com.github.hcsp.entity.RankItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankDao {

    @Autowired
    private SqlSession session;

    public List<RankItem> selectAndGetRank() {
        return session.selectList("myBlogMapper.selectAndGetRank");
    }
}
