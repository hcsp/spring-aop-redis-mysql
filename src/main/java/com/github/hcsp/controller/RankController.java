package com.github.hcsp.controller;

import com.github.hcsp.entity.Rank;
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
    private final RankService rankService;

    @Autowired
    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @RequestMapping("/rank.htm")
    public ModelAndView index() {
        List<Rank> ranks = rankService.getGoodsRank();
        Map<String, Object> model = new HashMap<>();
        model.put("ranks", ranks);
        return new ModelAndView("index", model);
    }
}
