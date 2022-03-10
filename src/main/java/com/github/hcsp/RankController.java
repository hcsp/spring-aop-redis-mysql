package com.github.hcsp;

import com.github.hcsp.entity.Rank;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
public class RankController {

    final
    RankService rankService;

    @Autowired
    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @RequestMapping("/*")
    public ModelAndView index() {
        List<Rank> items = rankService.getGoodsRankByDesc();
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", items);
        return new ModelAndView("rank", model);
    }
}
