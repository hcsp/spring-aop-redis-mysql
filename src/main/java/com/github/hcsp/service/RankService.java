package com.github.hcsp.service;


import com.github.hcsp.annotation.Cache;
import com.github.hcsp.dao.RankDao;
import com.github.hcsp.dao.UserMapper;
import com.github.hcsp.entity.RankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RankDao rankDao;

    @Cache
    public List<RankItem> getRank() {
        return rankDao.getRank();
    }
}
