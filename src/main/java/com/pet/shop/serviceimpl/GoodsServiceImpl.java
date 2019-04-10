package com.pet.shop.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pet.shop.mapper.FirstTitleMapper;
import com.pet.shop.mapper.GoodsMapper;
import com.pet.shop.mapper.SecondTitleMapper;
import com.pet.shop.model.Goods;
import com.pet.shop.service.GoodsService;
import com.pet.shop.service.upload;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 商品服务类实现类
 * @author 昂太 (angtai@maihaoche.com)
 */

@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private FirstTitleMapper firstTitleMapper;
    @Autowired
    private SecondTitleMapper secondTitleMapper;
    @Autowired
    private upload upload;

    @Override
    public PageInfo<Goods> queryAllGoods(Goods goods) {
        if(Objects.isNull(goods.getPage()) || goods.getPage() < 0 ){
           goods.setPage(1);
        }
        if(Objects.isNull(goods.getPageSize()) ||  goods.getPageSize() < 0){
            goods.setPageSize(10);
        }
        PageHelper.startPage(goods.getPage(),goods.getPageSize());
        try {
            List<Goods> result = goodsMapper.queryAllgoods(goods);
            result.stream().forEach(x->{
                //一级标题二级标题取名字
                x.setSubTypeDesc(firstTitleMapper.queryOne(x.getSubType()).getName());
                x.setSupTypeDesc(secondTitleMapper.queryOne(x.getSupType()).getName());
            });
            PageInfo<Goods> pageInfo =new PageInfo<>(result);
            return pageInfo;
        } catch (Exception e) {
            log.error("查询商品信息失败,入参{}",goods.toString(),e);
            e.printStackTrace();
        }
        return new PageInfo<>();
    }

    @Override
    public void deleteOneGood(Integer id) {
        Assert.notNull(id,"根据ID删除ID不能为空");
        try {
            goodsMapper.deleteOneGood(id);
        } catch (Exception e) {
            log.error("根据ID={}删除失败",id,e);
            e.printStackTrace();
        }
    }

    @Override
    public void addGoods(Goods goods) {
        Assert.notNull(goods,"新增商品不能为空");
        try {
            goodsMapper.addGood(goods);
        } catch (Exception e) {
            log.error("新增商品失败,入参{}",goods,e);
            e.printStackTrace();
        }


    }

    @Override
    public List<Goods> queryAllGoodsByRecommend() {
        List<Goods> goods = null;
        try {
             goods = goodsMapper.queryAllgoodsByRecommend();
        } catch (Exception e) {
            log.error("查询推荐商品失败",e);
            e.printStackTrace();
        }
        return goods;
    }
}