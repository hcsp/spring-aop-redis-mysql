package com.github.hcsp.controllers;

import com.github.hcsp.services.RankOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {
    @Resource
    private RankOrderService rankOrderService;

    @RequestMapping("/")
    public void selectOrderRank() {

    }
}
