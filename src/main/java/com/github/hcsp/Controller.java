package com.github.hcsp;

import com.github.hcsp.entity.SellRankItem;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private RankService rankService;

    @RequestMapping("/rank.htm")
    @ResponseBody
    public Object search(HttpServletRequest request, HttpServletResponse response){
        List<SellRankItem> sellRank = rankService.getSellRank();
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", sellRank);
        return new ModelAndView("rank", model);
    }

}
