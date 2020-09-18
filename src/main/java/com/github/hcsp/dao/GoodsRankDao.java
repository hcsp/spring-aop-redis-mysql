package com.github.hcsp.dao;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.entity.GoodsRank;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsRankDao {
    @Autowired
    private SqlSession session;

    @Cache
    public List<GoodsRank> getGoodsRank() {
        return session.selectList("MyMapper.selectRank");
    }
}
