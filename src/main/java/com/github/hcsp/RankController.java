package com.github.hcsp;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RankController {
    @Autowired
    private RankService rankService;

    @RequestMapping("/rank.htm")
    public ModelAndView index() {
        List<RankItem> rankResult = rankService.getRank();
        Map<String, Object> model = new HashMap<>();
        model.put("items", rankResult);
        return new ModelAndView("index", model);
    }
}
