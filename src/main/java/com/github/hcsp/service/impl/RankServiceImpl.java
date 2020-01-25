package com.github.hcsp.service.impl;

import com.github.hcsp.annotation.Cache;
import com.github.hcsp.entity.Item;
import com.github.hcsp.mapper.RankMapper;
import com.github.hcsp.service.IRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankServiceImpl implements IRankService {
    @Autowired
    RankMapper rankMapper;

    @Override
    @Cache
    public List<Item> getRankItemList() {
        return rankMapper.getRankItemList();
    }
}
