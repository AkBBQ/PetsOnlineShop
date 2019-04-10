package com.pet.shop.controller;


import com.pet.shop.model.Goods;
import com.pet.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商城Controller
 * @author 昂太
 *
 */
@RequestMapping("/shop")
@Controller
public class ShopController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/queryAllGoods")
    public String queryAllGoods(Goods goods, Model model){
      model.addAttribute("Goods",goodsService.queryAllGoods(goods).getList());
        return "goodshop";
    }

}