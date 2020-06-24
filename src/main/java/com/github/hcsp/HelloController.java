package com.github.hcsp;

import com.github.hcsp.Service.RankService;
import com.github.hcsp.anno.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@RestController
public class HelloController {
    @Autowired
    private RankService rankService;

    @RequestMapping("/rankData")
    @ResponseBody
    @Cache
    public Object getRnakData() {
        return rankService.getRank();
    }

}
