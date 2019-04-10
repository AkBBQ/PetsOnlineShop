package com.pet.shop.controller;

import com.pet.shop.model.Goods;
import com.pet.shop.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图控制器
 * @author 孙杰
 *
 */

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 首页视图
     */
    @RequestMapping("/")
    public String  hello(Model model){
        log.info("准备进入首页！");
        model.addAttribute("Recommend",goodsService.queryAllGoodsByRecommend());
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
     * 购物车页面
     */
    @RequestMapping("/goToShopCart")
    public String goToShopCart(){
        return "shopcart";
    }

    /**
     * 商品详情页面
     */
    @RequestMapping("/goodsInfo")
    public String goodsInfo(Integer id,Model model){
        Assert.notNull(id,"商品Id不能为空");
        Goods goods = new Goods();
        goods.setId(id);
        model.addAttribute("goodInfo",goodsService.queryAllGoods(goods).getList());
        return "goodinfo";
    }

}
