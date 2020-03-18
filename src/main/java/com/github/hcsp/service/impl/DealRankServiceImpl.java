package com.github.hcsp.service.impl;

import com.github.hcsp.DAO.DealRankDAO;
import com.github.hcsp.entity.GoodsDealInfo;
import com.github.hcsp.myAnnotation.Cache;
import com.github.hcsp.service.DealRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: Lzj
 * Date: 2020-03-18
 * Time: 12:54
 */
@Service
public class DealRankServiceImpl implements DealRankService {
    @Autowired
    private DealRankDAO dealRankDAO;

    @Cache
    @Override
    public List<GoodsDealInfo> getDealRank() {
        return dealRankDAO.getDealRank();
    }
}
