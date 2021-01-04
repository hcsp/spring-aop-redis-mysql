package com.github.hcsp.controller;

import com.github.hcsp.entity.GoodsRank;
import com.github.hcsp.service.GoodsRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ruby
 * @date 2021/1/4 0:10
 */
@Controller
public class GoodsRankController {
    @Autowired
    private GoodsRankService goodsRankService;

    @GetMapping("/rank.htm")
    public ModelAndView index() {
        Map<String, Object> model = new HashMap<>();
        List<GoodsRank> goodsRanks = goodsRankService.selectGoodsRankList();
        model.put("goodsRanks", goodsRanks);
        return new ModelAndView("rank", model);
    }

}
