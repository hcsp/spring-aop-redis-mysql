package com.github.hcsp;

import com.github.hcsp.service.GoodsService;
import com.github.hcsp.service.OrderService;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RankService rankService;

    @RequestMapping("/")
    @ResponseBody//要添加该注解，返回结果给浏览器
    public Object index(){
        Map<String, Object> model = new HashMap<>();
        model.put("rankList", rankService.getRankList());
        return new ModelAndView("index", model);
    }

    @RequestMapping("/order")
    @ResponseBody
    public Object order(){
        return orderService.getOrderList();
    }

    //指定多个路径映射到同一个回调
    @RequestMapping(value={"/rank", "/rank.html", "/rank.htm"})
    public Object rank(){
        Map<String, Object> model = new HashMap<>();
        model.put("rankList", rankService.getRankList());
        return new ModelAndView("index", model);
    }
}
