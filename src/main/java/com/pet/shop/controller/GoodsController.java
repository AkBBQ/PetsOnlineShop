package com.pet.shop.controller;

import com.pet.shop.model.Goods;
import com.pet.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品Controller
 * @throws
 * @author 昂太
 *
 */
@Controller
@RequestMapping("/Goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 查询全部商品(支持多条件)
     * @param goods
     * @param model
     * @return
     */
    @RequestMapping("/queryAllGoods")
    public String queryAllGoods(Goods goods ,Model model){
       model.addAttribute("GoodsList",goodsService.queryAllGoods(goods).getList());
       model.addAttribute("Pages",goodsService.queryAllGoods(goods));
       return "admin/goods";
    }

    @ResponseBody
    @RequestMapping("/deleteOne")
    public void delete(Integer id){
        goodsService.deleteOneGood(id);
    }


}