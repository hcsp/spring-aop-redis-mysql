package com.github.hcsp;

import com.github.hcsp.Service.RankService;
import com.github.hcsp.anno.Cache;
import com.github.hcsp.entity.RankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private RankService rankService;

    @RequestMapping("/rankData")
    @ResponseBody
    @Cache
    public Object getRnakData() {
        return rankService.getRank();
    }

    @RequestMapping("/rank.htm")
    public ModelAndView index() {
        List<RankItem> items = rankService.getRank();
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", items);
        return new ModelAndView("index", model);

    }

}
