package com.github.hcsp.service.impl;

import com.github.hcsp.mapper.RankMapper;
import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.IRankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RankServiceImpl implements IRankService {
    @Resource
    private RankMapper rankMapper;

    @Override
    public List<RankItem> selectRank() {
        return rankMapper.selectRank();
    }
}
