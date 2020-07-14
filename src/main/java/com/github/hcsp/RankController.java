package com.github.hcsp;

import com.github.hcsp.entity.Rank;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class RankController {
    @Autowired
    RankService rankService;

    @GetMapping("rank.htm")
    public ModelAndView getRank() {
        List<Rank> rankData = rankService.getRank();
        ModelAndView rank = new ModelAndView("rank");
        rank.addObject("rankData", rankData);
        return rank;
    }

    @GetMapping("rankData")
    @ResponseBody
    public List<Rank> getRankData() {
        return rankService.getRank();
    }
}
