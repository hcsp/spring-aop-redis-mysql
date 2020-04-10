package com.github.hcsp.controller;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.IRankService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class RankController {
    @Resource
    private IRankService rankService;

    @RequestMapping("/rank.htm")
    public ModelAndView index() {
        List<RankItem> items = rankService.selectRank();
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", items);
        return new ModelAndView("index", model);
    }
}
