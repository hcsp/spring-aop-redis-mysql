package com.github.hcsp.controller;

import com.github.hcsp.dao.UserMapper;
import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RankController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RankService rankService;

    @RequestMapping("/")
    public ModelAndView index() {
        List<RankItem> items = rankService.getRank();
        Map<String, Object> model = new HashMap<>();
        model.put("items", items);
        return new ModelAndView("index", model);
    }
}
