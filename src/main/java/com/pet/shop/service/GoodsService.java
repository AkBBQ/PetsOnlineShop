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

    void deleteOneGood(Integer id);
}
