package com.github.hcsp.service;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.dao.RankDao;
import com.github.hcsp.entity.RankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 这是一个bean（通过声明一个服务告诉springboot）
@Service
public class RankService {

    // service 必须依赖数据库访问数据库(通过注解)
    @Autowired
    private RankDao rankDao;

    @Cache
    public List<RankItem> getRanksByService() {
        // 使用dao层
        return rankDao.getRankByDao();
    }
}
