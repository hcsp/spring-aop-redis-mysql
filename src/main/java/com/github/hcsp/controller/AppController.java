package com.github.hcsp.controller;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.RankService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
public class AppController {
    private final RankService rankService;

    public AppController(RankService rankService) {
        this.rankService = rankService;
    }

    @RequestMapping("/rank.htm")
    public ModelAndView index() {
        HashMap<String, Object> model = new HashMap<>();
        List<RankItem> result = rankService.getRank();
        model.put("result", result);
        return new ModelAndView("index", model);
    }
}
