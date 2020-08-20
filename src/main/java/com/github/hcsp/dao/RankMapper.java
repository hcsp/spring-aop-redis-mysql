package com.github.hcsp.dao;

import com.github.hcsp.entity.Rank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: YangHuiQuan
 * @Description:
 * @Date: 2020/8/19 13:58
 * @version: 1.0
 * @since: JDK 8
 */
@Mapper
public interface RankMapper {
    List<Rank> getRank();
}
