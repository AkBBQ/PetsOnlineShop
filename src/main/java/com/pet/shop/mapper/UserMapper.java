package com.pet.shop.mapper;

import com.pet.shop.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户Mapper
 *
 * @author 昂太 (angtai@maihaoche.com)
 */
@Mapper
public interface UserMapper {
    /**
     * 用户登录
     * @param user
     * @return
     */
    @Select("select * from user where phone =#{phone}")
    User login(User user);
}
