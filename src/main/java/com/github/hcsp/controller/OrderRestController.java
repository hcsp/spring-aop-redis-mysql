package com.github.hcsp.controller;

import com.github.hcsp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/rank.htm")
    @ResponseBody
    public Object getOrderRanks() {
        Map<String, Object> model = new HashMap<>();
        model.put("items", orderService.getOrderRanks());
        return new ModelAndView("index", model);
    }
}
