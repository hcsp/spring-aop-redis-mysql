package com.github.hcsp;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RankControllor {
    @Autowired
    private RankService rankService;

    @RequestMapping("/rankData")
    @ResponseBody
    public Object rankData() {
        return rankService.getRank();
    }

    @RequestMapping("/rank.htm")
    public ModelAndView index() {
        List<RankItem> rankItems = rankService.getRank();
        Map<String, Object> model = new HashMap<>();
        model.put("rankItems", rankItems);
        return new ModelAndView("index", model);
    }
}
