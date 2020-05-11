package com.github.hcsp.mall.controller;

import com.github.hcsp.mall.service.RankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("rank")
public class RankController {

    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @GetMapping
    public ModelAndView getRankItems() {
        Map<String, Object> model = new HashMap<>();
        model.put("items", rankService.getRankItems());
        return new ModelAndView("index", model);
    }

}
