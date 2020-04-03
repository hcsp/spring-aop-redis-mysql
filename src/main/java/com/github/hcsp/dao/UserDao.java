package com.github.hcsp.dao;

import com.github.hcsp.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
    @Autowired
    SqlSession sqlSession;
    public User getUser(){
        User user=sqlSession.selectOne("db.mybatis.myMapper.returnUser");
        return user;
    }
}
