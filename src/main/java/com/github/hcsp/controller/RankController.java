package com.github.hcsp.controller;

import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhaofeng Zhou
 * @date 2021/8/2/002 21:39
 */
@Controller
@RequestMapping("/rank")
public class RankController {
    private RankService rankService;

    @Autowired
    public RankController(RankService rankService) {
        this.rankService = rankService;
    }


    @RequestMapping("/list")
    public ModelAndView rankList() {
        List<Map> rankList = rankService.getRankList();
        Map<String, Object> map = new HashMap<>();
        map.put("rankList", rankList);
        return new ModelAndView("rank", map);
    }
}
