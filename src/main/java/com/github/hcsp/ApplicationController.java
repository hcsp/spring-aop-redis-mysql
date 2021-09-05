package com.github.hcsp;

import com.github.hcsp.entity.GoodsSalesRankItem;
import com.github.hcsp.service.GoodsSalesRankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApplicationController {
    private final GoodsSalesRankService goodsSalesRankService;

    public ApplicationController(GoodsSalesRankService goodsSalesRankService) {
        this.goodsSalesRankService = goodsSalesRankService;
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/getGoodsSalesRank")
    public List<GoodsSalesRankItem> getGoodsSalesRank() {
        return this.goodsSalesRankService.getGoodsSalesRank();
    }

    @RequestMapping("/rank.htm")
    public ModelAndView getGoodsSalesRankList() {
        List<GoodsSalesRankItem> goodsSalesRankItemList = this.goodsSalesRankService.getGoodsSalesRank();
        Map<String, List<GoodsSalesRankItem>> map = new HashMap<>();
        map.put("goodsSalesRankItemList", goodsSalesRankItemList);

        return new ModelAndView("index", map);
    }
}
