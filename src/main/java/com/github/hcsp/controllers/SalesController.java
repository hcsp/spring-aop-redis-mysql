package com.github.hcsp.controllers;

import com.github.hcsp.entity.GoodsSaleRankItem;
import com.github.hcsp.services.RankGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SalesController {
    @Autowired
    RankGoodsService rankGoodsService;

    @RequestMapping("/rank.htm")
    public ModelAndView getGoodsRank() {
        List<GoodsSaleRankItem> results = rankGoodsService.doService();
        Map<String, Object> model = new HashMap<>();
        model.put("items", results);
        System.out.println(model);
        return new ModelAndView("rank", model);
    }
}
