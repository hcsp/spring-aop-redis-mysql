package com.github.hcsp.service;

import com.github.hcsp.annotation.Cache;
import com.github.hcsp.dao.SaleMapper;
import com.github.hcsp.entity.SalesRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetSalesRank {

    @Autowired
    SaleMapper saleMapper;

    @Cache(cacheSeconds = 1)
    public List<SalesRank> getSalesByGoods() {
        return saleMapper.getSalesRank();
    }
}
