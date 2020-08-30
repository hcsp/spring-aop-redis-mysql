package com.github.hcsp.rest;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RankController
 * @Description:
 * @date 2020-08-30
 */
@RestController
public class RankController {

    @Autowired
    private RankService rankService;

    @RequestMapping(value = "/rank.htm")
    @ResponseBody
    public ModelAndView search() {
        List<RankItem> rankItemList = rankService.selectRank();
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", rankItemList);
        return new ModelAndView("rank", model);
    }

}
