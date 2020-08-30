package com.github.hcsp.service;

import com.github.hcsp.cache.Cache;
import com.github.hcsp.dao.RankDao;
import com.github.hcsp.entity.RankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RankService
 * @Description:
 * @date 2020-08-30
 */
@Service
public class RankService {

    @Autowired
    private RankDao rankDao;

    @Cache
    public List<RankItem> selectRank(){
        return rankDao.getRank();
    }

}
