package com.github.hcsp;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private RankService rankService;

    @RequestMapping("/")
    @ResponseBody
    public ModelAndView index() {
        List<RankItem> rank = rankService.getRank();
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", rank);
        return new ModelAndView("index", model);
    }

}
