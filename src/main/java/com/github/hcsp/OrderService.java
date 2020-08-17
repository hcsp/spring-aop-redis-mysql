package com.github.hcsp;

import com.github.hcsp.AOP.Cache;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    final
    OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Cache
    public List<Order> getRankList() {
        return orderMapper.getRank();
    }
}
