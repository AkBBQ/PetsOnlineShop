package com.pet.shop.controller;

import com.pet.shop.model.FirstTitle;
import com.pet.shop.model.Goods;
import com.pet.shop.service.GoodsService;
import com.pet.shop.service.TitleService;
import com.pet.shop.service.upload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;

/**
 * 商品Controller
 * @throws
 * @author 昂太
 *
 */
@Slf4j
@Controller
@RequestMapping("/Goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private upload upload;
    @Autowired
    private TitleService titleService;

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

    /**
     * 根据主键ID删商品
     * @param id
     */
    @ResponseBody
    @RequestMapping("/deleteOne")
    public void delete(Integer id){
        goodsService.deleteOneGood(id);
    }

    /**
     * 商品添加界面
     */
    @RequestMapping("/beforeAddGoods")
    public String goodsAdd(Model model){
        List<FirstTitle> firstTitles = titleService.queryAllFirst();
        if(!CollectionUtils.isEmpty(firstTitles)){
          model.addAttribute("FirstTitle",firstTitles);
        }
        return "admin/goods-add";
    }

    /**
     * 新增商品
     */
    @RequestMapping("/addGoods")
    public void addGoods(@RequestParam("name") String name,
                         @RequestParam("price") String price,
                         @RequestParam("supType") Integer supType,
                         @RequestParam("subType") Integer subType,
                         @RequestParam("isRecommend") Integer isRecommend,
                         @RequestParam("sex") Integer sex,
                         @RequestParam("age") Integer age,
                         @RequestParam("myFile") File file ){
        //图片名 sj+系统时间戳
        String imageName ="sj"+System.currentTimeMillis();
        //上传图片
        try {
            upload.uoload(file,imageName);

            Goods goods = new Goods();
            goods.setName(name);
            goods.setPrice(price);
            goods.setSupType(supType);
            goods.setSubType(subType);
            goods.setIsRecommend(isRecommend);
            goods.setSex(sex);
            goods.setAge(age);
            goods.setImage(imageName);
            goodsService.addGoods(goods);
        } catch (Exception e) {
          log.error("新增商品失败",e);
        }

    }

}