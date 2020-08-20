package com.github.hcsp.service;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.dao.RankMapper;
import com.github.hcsp.entity.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: YangHuiQuan
 * @Description:
 * @Date: 2020/8/19 13:51
 * @version: 1.0
 * @since: JDK 8
 */

@Service
public class RankService {
    @Autowired
    private RankMapper rankMapper;

    @Cache
    public List<Rank> getRank() {
        List<Rank> ranks = rankMapper.getRank();
        System.out.println(ranks);
        return ranks;
    }


}
