package com.github.hcsp.service.impl;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.dao.RankDao;
import com.github.hcsp.entity.RankItem;
import com.github.hcsp.entity.User;
import com.github.hcsp.service.RankService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankDao rankDao;

    @Override
    public User getUserById(int id) {
        return rankDao.getUserById(id);
    }

    @Cache
    @Override
    public List<RankItem> getRank() {
        return rankDao.getRank();
    }
}
