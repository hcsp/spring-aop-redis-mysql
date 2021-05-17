package com.github.hcsp.controller;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.RankService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RankController {
    @Autowired
    private RankService rankService;

    @GetMapping("/user")
    public Object getUser() {
        return rankService.getUserById(1);
    }

    @GetMapping("/getRank")
    @ResponseBody
    public Object getGoodsRank() {
        return rankService.getRank();
    }

    @GetMapping("/rank.htm")
    public ModelAndView index() {
        List<RankItem> items = rankService.getRank();
        Map<String, Object> model = new HashMap<>();
        model.put("items", items);
        return new ModelAndView("index", model);
    }
}
