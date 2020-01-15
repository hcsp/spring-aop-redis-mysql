package com.github.hcsp.dao;

import com.github.hcsp.entity.RankItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<RankItem> selectRank();
}
