/**
 *
 */
package com.github.hcsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.hcsp.annotation.Cache;
import com.github.hcsp.dao.ItemRank;
import com.github.hcsp.dao.ItemRankMapper;

/**
 * @author sunp
 *
 */

@RestController
public class ItemRankController {

    @Autowired
    private ItemRankMapper itemRankMapper;

    @RequestMapping("/rank")
    @ResponseBody
    @Cache
    public List<ItemRank> index() {
        return itemRankMapper.queryItemRank();
    }

}
