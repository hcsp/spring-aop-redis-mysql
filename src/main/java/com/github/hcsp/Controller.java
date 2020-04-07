package com.github.hcsp;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.Rankservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    @Autowired
    Rankservice rankservice;

    @GetMapping()
    public ModelAndView hello() {
        List<RankItem> list = rankservice.getRank();
        Map map = new HashMap<>();
        map.put("rankItems", list);
        ModelAndView modelAndView = new ModelAndView("index", map);
        return modelAndView;
    }
}

