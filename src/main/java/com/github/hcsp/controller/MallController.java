package com.github.hcsp.controller;

import com.github.hcsp.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class MallController {

    private MallService mallService;

    @Autowired
    public MallController(MallService mallService) {
        this.mallService = mallService;
    }

    @RequestMapping("/rank.htm")
    public ModelAndView index() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("items", mallService.getGoodAmountRank());
        return new ModelAndView("rank", params);
    }

}
