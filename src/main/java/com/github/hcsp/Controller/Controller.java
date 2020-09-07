package com.github.hcsp.Controller;


import java.util.HashMap;
import java.util.List;

import com.github.hcsp.Manager.goodsRankManager;
import com.github.hcsp.Moudle.RankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
    private final goodsRankManager goodsRankManager;

    @Autowired
    public Controller(goodsRankManager goodsRankManager) {
        this.goodsRankManager = goodsRankManager;
    }

    @GetMapping(path = "/rank.htm", produces = "application/json")
    public ModelAndView getGoodsRank() {
        List<RankItem> items = goodsRankManager.getGoodsRank();
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", items);
        return new ModelAndView("Rank", model);
    }
}
