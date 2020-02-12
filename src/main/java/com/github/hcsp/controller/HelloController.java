package com.github.hcsp.controller;

import com.github.hcsp.service.GetSalesRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    GetSalesRank getSalesRank;

    @RequestMapping("/")
    public Object index() {
        return "hello!";
    }

    @RequestMapping("/rankData")
    @ResponseBody
    public Object getRankData() {
        return getSalesRank.getSalesByGoods();
    }
}
