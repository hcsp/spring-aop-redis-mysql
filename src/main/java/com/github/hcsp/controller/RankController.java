package com.github.hcsp.controller;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.RankService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RankController {
    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @RequestMapping("/rank.htm")
    public ModelAndView getRankData() {
        List<RankItem> rankItemList = rankService.getRank();
        Map<String, Object> model = new HashMap<>();
        model.put("items", rankItemList);
        return new ModelAndView("rank", model);
    }
}
