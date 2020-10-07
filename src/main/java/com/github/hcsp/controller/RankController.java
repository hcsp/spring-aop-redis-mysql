package com.github.hcsp.controller;

import com.github.hcsp.service.RankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RankController {
    @Inject
    private RankService rankService;

    @GetMapping("/rank.htm")
    public ModelAndView getRank() {
        Map<String, Object> collect = new HashMap<>();
        collect.put("rankItems", rankService.getRank());
        return new ModelAndView("rank", collect);
    }

    @GetMapping("/rank2")
    public Object test() {
        return rankService.getRank();
    }
}
