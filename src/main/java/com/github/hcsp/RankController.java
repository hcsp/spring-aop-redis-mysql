package com.github.hcsp;

import com.github.hcsp.entity.GoodsRank;
import com.github.hcsp.service.GoodsRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
public class RankController {

    @Autowired
    private GoodsRankService rankService;

    //调用freeMarker模板
    @RequestMapping("/rank.htm")
    public ModelAndView index() {
        List<GoodsRank> items = rankService.getRank();
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", items);
        return new ModelAndView("rank", model);
    }
}
