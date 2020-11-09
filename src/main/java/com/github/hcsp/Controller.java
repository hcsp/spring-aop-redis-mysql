package com.github.hcsp;

import com.github.hcsp.entity.Order;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    RankService rankService;

    @RequestMapping("/rank.htm")
    public ModelAndView index() {
        List<Order> items = rankService.getGoodsRankByDesc();
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", items);
        return new ModelAndView("rank", model);
    }
}
