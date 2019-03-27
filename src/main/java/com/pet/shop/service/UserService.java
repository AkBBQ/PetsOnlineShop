package com.pet.shop.service;

import com.pet.shop.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * 用户登录注册服务
 * @author 昂太
 *
 */
public interface UserService {
    /**
     * 登录服务
     */
     int login(User user);
}
