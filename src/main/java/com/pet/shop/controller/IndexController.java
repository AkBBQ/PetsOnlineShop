package com.pet.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
