package com.github.hcsp.services;

import com.github.hcsp.dao.RankOrderDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RankOrderService {
    @Resource
    RankOrderDao rankOrderDao;
}
