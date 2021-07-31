package com.github.hcsp.controller;

import com.github.hcsp.entity.GoodsRank;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RankController {
    @Autowired
    RankService rankService;

    @RequestMapping("/rank.htm")
    public ModelAndView index() {
        List<GoodsRank> items = rankService.getRank();
        Map<String, Object> map = new HashMap<>();
        map.put("items", items);
        return new ModelAndView("index", map);
    }
}
