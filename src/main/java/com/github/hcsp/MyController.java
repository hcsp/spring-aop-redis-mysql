package com.github.hcsp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;


@RestController
public class MyController {
    final OrderService orderService;

    public MyController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("rank.htm")
    public ModelAndView index() {
        List<Order> rankList = orderService.getRankList();
        HashMap<String, Object> params = new HashMap<>();
        params.put("rankList", rankList);
        return new ModelAndView("rank", params);
    }
}
