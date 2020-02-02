package com.github.hcsp.controller;

import com.github.hcsp.entity.Rankitem;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {
    @Autowired
    private RankService rankService;

    @RequestMapping("/rank.htm")
//    @ResponseBody
    public ModelAndView search() {
        List<Rankitem> rankItemList = rankService.getRank();
        Map<String, Object> model = new HashMap<>();
        model.put("items", rankItemList);
        return new ModelAndView("index", model);
    }
}
