package com.github.hcsp;

import com.github.hcsp.Service.RankService;
import com.github.hcsp.entity.RankingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RankController {

    private RankService rankService;

    @Autowired
    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @RequestMapping("/rank.htm")
    @ResponseBody
    public Object search(HttpServletRequest request, HttpServletResponse response) {
        List<RankingList> items = rankService.SortTheAmountOfGoodsSold();
        Map<String, Object> model = new HashMap<>();
        model.put("items", items);
        return new ModelAndView("index", model);
    }

}
