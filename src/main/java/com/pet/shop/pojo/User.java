package com.pet.shop.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 用户类
 */
@Data
public class User {

    /**
     * 自增id
     */
    public Integer id;
    /**
     * 用户名
     */
    public String name;
    /**
     * 密码
     */
    public String pwd;
    /**
     * 手机号
     */
    public String phone;
    /**
     * 权限
     */
    public Integer identity;
    /**
     * 地址
     */
    public String place;

    /**
     * 注册时间
     */
    public Date creatTime;
}
