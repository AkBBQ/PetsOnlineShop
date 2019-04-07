package com.pet.shop.controller;

import com.pet.shop.service.TitleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图控制器
 * @author 孙杰
 *
 */

@Slf4j
@Controller
public class IndexController {

    /**
     * 首页视图
     */
    @RequestMapping("/")
    public String  hello(){
        log.info("准备进入首页！");
        return "index";
    }

    /**
     * 登录视图
     */
    @RequestMapping("/login")
    public  String login(){
        return "login";
    }

    /**
     * 返回首页
     */
    @RequestMapping("toIndex")
    public String toindex(){
        return "index";
    }

    /**
     * 跳转到注册页面
     */
    @RequestMapping("goToRegister")
    public String toRegister(){
        return "register";
    }

    /**
     * 管理员登录
     */
    @RequestMapping("adminLogin")
    public String adminLogin(){
        return "admin/login";
    }

    /**
     * 后台首页
     */
    @RequestMapping("adminIndex")
    public String adminIndex(){
        return "admin/index";
    }

    /**
     * 后台欢迎页面（代办中心）
     */
    @RequestMapping("adminWelcome")
    public String adminWelcome(){
        return "admin/welcome";
    }

    /**
     * 商品添加界面
     */
    @RequestMapping("/addGoods")
    public String goodsAdd(){
        return "admin/goods-add";
    }

}
