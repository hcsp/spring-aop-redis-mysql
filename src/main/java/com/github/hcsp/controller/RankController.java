package com.github.hcsp.controller;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
public class RankController {

    @Autowired
    private RankService rankService;


    @RequestMapping("/")
    public Object index() {
        return "hello!";
    }

    @RequestMapping(value = "/rank.htm")
    @ResponseBody
    public ModelAndView search() {
        List<RankItem> rankItemList = rankService.selectRank();
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", rankItemList);
        return new ModelAndView("rank", model);
    }
}