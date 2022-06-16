package com.github.hcsp;


import com.github.hcsp.service.RankService;
import com.github.hcsp.entity.RankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
public class RankController {
    @Autowired
    private RankService rankService;

    @RequestMapping("/rank.htm")
    public ModelAndView getRank() {
        List<RankItem> items = rankService.getRank();
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", items);
        return new ModelAndView("index", model);
    }
}
