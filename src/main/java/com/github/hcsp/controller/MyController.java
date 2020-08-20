package com.github.hcsp.controller;

import com.github.hcsp.entity.Rank;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: YangHuiQuan
 * @Description:
 * @Date: 2020/8/19 15:01
 * @version: 1.0
 * @since: JDK 8
 */
@Controller
public class MyController {
    @Autowired
    private RankService rankService;

    @RequestMapping("/rank.htm")
    @ResponseBody
    public ModelAndView index() {
        List<Rank> ranks = rankService.getRank();
        HashMap<String, Object> model = new HashMap<>();
        model.put("ranks", ranks);
        return new ModelAndView("index", model);
    }


}
