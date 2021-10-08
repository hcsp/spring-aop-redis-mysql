package com.github.hcsp.service;

import com.github.hcsp.annotation.Cache;
import com.github.hcsp.dao.OrderDao;
import com.github.hcsp.entity.OrderRankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    @Cache
    public List<OrderRankItem> getOrderRanks() {
        return orderDao.getOrderRanks();
    }
}
