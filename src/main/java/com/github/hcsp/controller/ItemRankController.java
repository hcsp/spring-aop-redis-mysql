/**
 *
 */
package com.github.hcsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.hcsp.dao.RankDao;

/**
 * @author sunp
 *
 */

@Controller
public class ItemRankController {

    @Autowired
    private RankDao rankDao;

    @RequestMapping("/rank.htm")
    public String index(ModelMap map) {
        map.put("itemList", rankDao.queryRankList());
        return "index";
    }
}
