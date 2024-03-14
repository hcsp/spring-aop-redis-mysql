package com.github.hcsp;

import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SqlController {
    @Autowired
    private RankService rankService;

    @GetMapping("/rank.htm")
    public ModelAndView postRank() {
        Map<String, Object> model = new HashMap<>();
        model.put("items", rankService.getRank());
        return new ModelAndView("index", model);
    }
}
