package com.github.hcsp.controller;

import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankController {

    @Autowired
    private RankService rankService;

    @GetMapping("/rankData")
    @ResponseBody
    public Object getRank() {
        return rankService.getRank();
    }
}
