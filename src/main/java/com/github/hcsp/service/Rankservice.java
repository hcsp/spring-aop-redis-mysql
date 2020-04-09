package com.github.hcsp.service;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.dao.RankItemDao;
import com.github.hcsp.entity.RankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rankservice {
    @Autowired
    RankItemDao rankItemDao;

    List<RankItem> result;

    @Cache
    public List getRank() {
        result=rankItemDao.getRankItem();
        return result;
    }
}
