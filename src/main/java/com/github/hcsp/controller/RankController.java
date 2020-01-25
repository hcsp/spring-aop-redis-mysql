package com.github.hcsp.controller;

import com.github.hcsp.entity.Item;
import com.github.hcsp.service.IRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RankController {
    @Autowired
    IRankService rankService;

    @GetMapping(value = "/rank.htm")
    public Object rank() {
        List<Item> items = rankService.getRankItemList();
        ModelAndView modelAndView = new ModelAndView("rank");
        modelAndView.addObject("ranklist", items);
        return modelAndView;
    }
}
