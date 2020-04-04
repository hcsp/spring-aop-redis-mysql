package com.github.hcsp;

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
public class HelloController {

    @Autowired
    private RankService rankService;

    @RequestMapping("/rank.htm")
    public ModelAndView rankData() {
        List<RankItem> items = rankService.getRank();
        Map<String, Object> model = new HashMap<>();
        model.put("items", items);
        return new ModelAndView("index", model);
    }
}
