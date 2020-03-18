package com.github.hcsp.controller;

import com.github.hcsp.entity.GoodsDealInfo;
import com.github.hcsp.service.DealRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * Description:
 * User: Lzj
 * Date: 2020-03-18
 * Time: 12:00
 */
@RestController
public class DealRankController {
    @Autowired
    private DealRankService dealRankService;

    @RequestMapping("/")
    public ModelAndView getDealRank() {
        HashMap<String, List<GoodsDealInfo>> model = new HashMap<>();
        List<GoodsDealInfo> dealRank = dealRankService.getDealRank();
        model.put("goods", dealRank);
        return new ModelAndView("rank", model);
    }
}
