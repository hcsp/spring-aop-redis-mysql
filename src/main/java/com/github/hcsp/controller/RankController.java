package com.github.hcsp.controller;

import com.github.hcsp.service.RankService;
import com.github.hcsp.entity.RankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RankController {
    private RankService rankService;

    @Autowired
    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @GetMapping("/rank")
    public String getRank(Model model) {
        List<RankItem> rank = rankService.getRank();
        model.addAttribute("rank", rank);
        return "rank";
    }
}
