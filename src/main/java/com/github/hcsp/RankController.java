package com.github.hcsp;

import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import java.util.HashMap;
import java.util.List;

@RestController
public class RankController {
    @Autowired
    private RankService rankService;

    @GetMapping("/rank.htm")
    public ModelAndView rankFreemarker() {
        HashMap<String, Object> model = new HashMap<>();
        List goods = rankService.getRank();
        model.put("goods", goods);
        return new ModelAndView("rank", model);
    }
}
