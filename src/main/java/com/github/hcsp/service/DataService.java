package com.github.hcsp.service;

import com.github.hcsp.Entity.Goods;
import com.github.hcsp.Entity.SaleOrder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: GoFocus
 * @Date: 2020-05-26 13:48
 * @Description:
 */

@Service
public interface DataService {

    List<Goods> findAllGoods();

    List<SaleOrder> getSaleOrder();

}
