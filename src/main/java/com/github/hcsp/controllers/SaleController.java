package com.github.hcsp.controllers;

import com.github.hcsp.entities.RankItem;
import com.github.hcsp.services.RankOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SaleController {
    @Resource
    private RankOrderService rankOrderService;

    @RequestMapping("/rank.htm")
    public ModelAndView selectOrderRank() {
        List<RankItem> results = rankOrderService.doService();
        Map<String, Object> model = new HashMap<>();
        model.put("items", results);
        return new ModelAndView("index", model);
    }
}
