package com.github.hcsp.dao;

import com.github.hcsp.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: YangHuiQuan
 * @Description:
 * @Date: 2020/8/19 13:19
 * @version: 1.0
 * @since: JDK 8
 */
@Mapper
public interface UserMapper {
    User getUserById(Integer id);
}
