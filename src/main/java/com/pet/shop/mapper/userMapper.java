package com.pet.shop.mapper;

import com.pet.shop.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userMapper {
    @Select("select * from user")
    public User login();
}
