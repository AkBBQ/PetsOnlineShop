package com.pet.shop.service;

import com.github.pagehelper.PageInfo;
import com.pet.shop.model.Goods;
/**
 * 商品服务类
 * @author 昂太 (angtai@maihaoche.com)
 */
public interface GoodsService {
    /**
     * 查询所有商品（支持多条件查询）
     */
    PageInfo<Goods> queryAllGoods(Goods goods);

    /**
     * 根据主键ID删除商品
     * @param id
     */
    void deleteOneGood(Integer id);

    /**
     * 添加商品
     */
    void addGoods(Goods goods);
}