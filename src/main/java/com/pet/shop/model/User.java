package com.pet.shop.model;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "自增主键", required = true)
    public Integer id;
    /**
     * 用户名
     */
    @ApiModelProperty(notes = "用户名", required = true)
    public String name;
    /**
     * 密码
     */
    @ApiModelProperty(notes = "密码", required = true)
    public String pwd;
    /**
     * 手机号
     */
    @ApiModelProperty(notes = "手机号", required = true)
    public String phone;
    /**
     * 权限
     */
    @ApiModelProperty(notes = "权限", required = true)
    public Integer identity;
    /**
     * 地址
     */
    @ApiModelProperty(notes = "地址", required = true)
    public String place;

    /**
     * 注册时间
     */
    @ApiModelProperty(notes = "注册时间", required = true)
    public Date creatTime;
}
