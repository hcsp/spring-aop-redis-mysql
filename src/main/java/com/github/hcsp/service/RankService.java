package com.github.hcsp.service;

import com.github.hcsp.anno.Cache;
import com.github.hcsp.dao.OrderMapper;
import com.github.hcsp.entity.RankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {
    private final OrderMapper orderMapper;

    @Autowired
    public RankService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Cache(cacheSeconds = 1)
    public List<RankItem> getRank() {
        return orderMapper.selectRank();
    }

}
