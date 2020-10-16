package com.github.hcsp;

import com.github.hcsp.entity.Item;
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
    RankService rankService;

    @RequestMapping("/rank.htm")
    public ModelAndView index() {
        Map<String, Object> model = new HashMap<>();
        List<Item> rank = rankService.getRank();
        model.put("rank", rank);
        return new ModelAndView("rank", model);
    }
}
