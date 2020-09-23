package com.github.hcsp.controller;

import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class HelloController {

    @Autowired
    private RankService rankService;

    @RequestMapping("/rank.htm")
    public ModelAndView index(HttpServletRequest request) {
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", rankService.getRanksByService());
        return new ModelAndView("index", model);
//        return rankService.getRanksByService();
    }
}

