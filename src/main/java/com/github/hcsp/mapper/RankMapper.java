package com.github.hcsp.mapper;

import com.github.hcsp.entity.RankItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RankMapper {
    List<RankItem> selectRank();
}
