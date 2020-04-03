package com.github.hcsp;

import com.github.hcsp.dao.UserDao;
import com.github.hcsp.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    UserDao userDao;

    @GetMapping()
    public User hello() {
        return userDao.getUser();
    }
}

