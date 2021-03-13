package com.github.hcsp.service;

import com.github.hcsp.dao.SaleDao;
import com.github.hcsp.entity.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleDao saleDao;

    public List<Money> getSale() {
        return saleDao.getSale();
    }
}
