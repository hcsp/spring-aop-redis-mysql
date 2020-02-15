package com.github.hcsp.controller;

import com.github.hcsp.entity.SalesRank;
import com.github.hcsp.service.GetSalesRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    GetSalesRank getSalesRank;

    @RequestMapping("/")
    public Object index() {
        return "hello!";
    }

    @RequestMapping("/rank.html")
    public ModelAndView getRankData() {
        Map<String, Object> model = new HashMap<>();
        List<SalesRank> salesRanksList = getSalesRank.getSalesByGoods();
        model.put("items", salesRanksList);
        return new ModelAndView("index", model);
    }

    @RequestMapping("/rankData")
    @ResponseBody
    // for JS ajax
    public Object getRankData1() {
        return getSalesRank.getSalesByGoods();
    }
}
