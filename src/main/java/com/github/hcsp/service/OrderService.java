package com.github.hcsp.service;

import com.github.hcsp.dao.OrderDao;
import com.github.hcsp.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public List<Order> getOrderList() {
        return orderDao.getOrderList();
    }
}
