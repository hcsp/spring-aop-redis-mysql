package com.github.hcsp.Service;

import com.github.hcsp.Dao.RankDao;
import com.github.hcsp.anno.Cache;
import com.github.hcsp.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class rankService {
    @Autowired
    RankDao rankDao;

    public List<Goods> getRank() {
        return rankDao.getRank();
    }

}
