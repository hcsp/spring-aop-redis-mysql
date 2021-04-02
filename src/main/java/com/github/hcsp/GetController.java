package com.github.hcsp;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class GetController {
    @Autowired
    RankService rankService;

    @GetMapping("rank.htm")
        public ModelAndView getRank() {
        List<RankItem> list = rankService.getRank();
        Map<String, List<RankItem>> params = new HashMap<>();
        params.put("rankItems", list);

        return new ModelAndView("rank", params);
    }
}
