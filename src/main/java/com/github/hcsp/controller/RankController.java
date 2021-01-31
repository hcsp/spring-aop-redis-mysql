package com.github.hcsp.controller;

import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RankController {
    @Autowired
    private RankService rankService;

    @GetMapping("/user")
    public Object getUser(){
        return rankService.getUserById(1);
    }

    @GetMapping("/getRank")
    @ResponseBody
    public Object getGoodsRank(){
        return rankService.getRank();
    }
}
