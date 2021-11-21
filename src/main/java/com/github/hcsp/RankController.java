package com.github.hcsp;

import com.github.hcsp.entity.Rank;
import com.github.hcsp.service.RankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
public class RankController {
    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @GetMapping("/rank.htm")
    @ResponseBody
    public ModelAndView index() {
        HashMap<String, Object> hashMap = new HashMap<>();
        List<Rank> rankList = rankService.getRank();
        hashMap.put("ranks", rankList);
        return new ModelAndView("index", hashMap);
    }
}
