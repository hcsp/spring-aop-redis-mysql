/**
 * 
 */
package com.github.hcsp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author sunp
 *
 */
@Mapper
@Repository
public interface itemRankMapper {

    List<itemRank> queryItemRank();
    
}
