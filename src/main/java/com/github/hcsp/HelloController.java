package com.github.hcsp;

import com.github.hcsp.Service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private RankService rankService;

    @RequestMapping("/rankData")
    @ResponseBody
    public Object getRankData() {
        return rankService.getRank();
    }
}
