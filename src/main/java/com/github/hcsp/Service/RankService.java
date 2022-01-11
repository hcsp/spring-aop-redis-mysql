package com.github.hcsp.Service;

import com.github.hcsp.Dao.RankDao;
import com.github.hcsp.anno.Cache;
import com.github.hcsp.entity.RankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {

    @Autowired
    private RankDao rankDao;

    @Cache
    public List<RankItem> selectAndGetRank() {
        return rankDao.selectAndGetRank();
    }
}
