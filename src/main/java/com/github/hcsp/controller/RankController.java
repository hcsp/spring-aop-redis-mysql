package com.github.hcsp.controller;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
public class RankController {
    @Autowired
    private RankService rankService;

    @RequestMapping("rank.htm")
    public ModelAndView index() {
        HashMap<String, List<RankItem>> model = new HashMap<>();
        List<RankItem> rank = rankService.getRank();
        model.put("goods", rank);
        return new ModelAndView("index", model);
    }
}