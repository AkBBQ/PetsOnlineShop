package com.pet.shop.controller;

import lombok.extern.slf4j.Slf4j;
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

    @RequestMapping("/")
    public String  hello(){
        log.info("准备进入首页！");
        return "index";
    }
    @RequestMapping("/login")
    public  String login(){
        return "login";
    }

    /**
     * 返回首页
     * @return
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
}
