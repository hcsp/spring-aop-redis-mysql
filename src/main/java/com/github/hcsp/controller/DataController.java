package com.github.hcsp.controller;

import com.github.hcsp.Entity.SaleOrder;
import com.github.hcsp.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: GoFocus
 * @Date: 2020-05-26 13:47
 * @Description:
 */

@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/goods")
    public Object getAllGoods() {
        return dataService.findAllGoods();
    }

    @GetMapping("/rank.htm")
    public String getSaleOrder(Model model) {
        List<SaleOrder> saleOrder = dataService.getSaleOrder();
        model.addAttribute("saleOrder", saleOrder);

        return "index";
    }
}
