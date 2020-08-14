/**
 *
 */
package com.github.hcsp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.hcsp.annotation.Cache;

/**
 * @author sunp
 *
 */
@Component
public class RankDao {

    @Autowired
    private ItemRankMapper itemRankMapper;

    @Cache
    public List<ItemRank> queryRankList(){
        List<ItemRank> list = itemRankMapper.queryItemRank();
        return list;
    }
}
