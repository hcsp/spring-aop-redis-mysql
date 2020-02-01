package com.github.hcsp;

import com.github.hcsp.entity.Goods;
import com.github.hcsp.service.GoodsRankService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class RankController {
    private GoodsRankService goodsRankService;

    @Inject
    public RankController(GoodsRankService goodsRankService) {
        this.goodsRankService = goodsRankService;
    }

    @GetMapping("/rank.htm")
    @ResponseBody
    public Object getGoodsRank(){
        List<Goods> goodsList = goodsRankService.getRankList();
        ModelAndView modelAndView = new ModelAndView("rank");
        modelAndView.addObject("rankedGoodsList", goodsList);
        return modelAndView;
    }
}
