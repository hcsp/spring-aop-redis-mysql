package com.github.hcsp.dao;

import com.github.hcsp.entity.RecordItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordDao {
    @Autowired
    private SqlSession sqlSession;

    public List<RecordItem> RecordDao() {
        return sqlSession.selectList("MyMapper.selectSingLe");
    }
}
