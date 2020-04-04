package com.github.hcsp.controller;

import com.github.hcsp.entity.Goods;
import com.github.hcsp.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MallController {

    private MallService mallService;

    @Autowired
    public MallController(MallService mallService) {
        this.mallService = mallService;
    }

    @GetMapping("rank.htm")
    public ModelAndView getSortedGoods() {
        final List<Goods> sortedGoods = mallService.getSortedGoods();
        final ModelAndView mall = new ModelAndView("mall");
        mall.addObject("sortedGoods", sortedGoods);
        return mall;
    }
}
