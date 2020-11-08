package com.github.hcsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RankController {

    private RankService rankService;

    public RankController(@Autowired RankService rankService) {
        this.rankService = rankService;
    }

    @RequestMapping("/rank.htm")
    public ModelAndView rank() {
        Map<String, Object> params = new HashMap<>();
        params.put("ranks", rankService.getRankItems());
        return new ModelAndView("rank", params);
    }
}
