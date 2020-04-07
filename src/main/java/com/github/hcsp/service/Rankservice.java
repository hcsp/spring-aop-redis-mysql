package com.github.hcsp.service;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.dao.RankItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rankservice {
    @Autowired
    RankItemDao rankItemDao;

    @Cache
    public List getRank() {
        return rankItemDao.getRankItem();
    }
}
