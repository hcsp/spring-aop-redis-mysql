package com.github.hcsp.service;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.dao.GoodsSalesDao;
import com.github.hcsp.entity.GoodsSales;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsSalesService {
    private final GoodsSalesDao goodsSalesDao;

    public GoodsSalesService(GoodsSalesDao goodsSalesDao) {
        this.goodsSalesDao = goodsSalesDao;
    }

    @Cache
    public List<GoodsSales> getGoodsSalesList() {
        return goodsSalesDao.getGoodsSalesList();
    }
}
