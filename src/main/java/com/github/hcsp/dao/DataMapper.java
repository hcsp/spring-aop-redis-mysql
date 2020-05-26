package com.github.hcsp.dao;

import com.github.hcsp.Entity.Goods;
import com.github.hcsp.Entity.SaleOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: GoFocus
 * @Date: 2020-05-26 14:06
 * @Description:
 */

@Mapper
public interface DataMapper {

    @Select("select * from goods")
    List<Goods> findAllGoods();

    List<SaleOrder> getSaleOrder();

}
