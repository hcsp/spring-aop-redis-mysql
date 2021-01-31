package com.github.hcsp.dao;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RankDao {
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") Integer id);

    List<RankItem> getRank();
}
