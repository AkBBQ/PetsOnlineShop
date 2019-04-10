package com.pet.shop.mapper;

import com.pet.shop.model.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 商品Mapper
 * @author 昂太 (angtai@maihaoche.com)
 *
 */
@Mapper
public interface GoodsMapper {

    /**
     * 查询全部商品
     * @param goods
     * @return
     */
    @Select({
    "<script>",
    "select * from goods",
    "<where>",

    "<if test=\"name != null and name !='' \">",
    "and name = #{name}",
    "</if>",

    "<if test='id != null'>",
    "and id = #{id}",
    "</if>",

    "<if test='sex != null'>",
    "and sex = #{sex}",
    "</if>",

    "<if test='isRecommend != null'>",
    "and isRecommend = #{isRecommend}",
    "</if>",

    "</where>",
    "</script>"})
    List<Goods> queryAllgoods(Goods goods);


    /**
     * 查询全部推荐商品
     * @param
     * @return
     */
    @Select("select * from goods where isRecommend = 1")
    List<Goods> queryAllgoodsByRecommend();
    /**
     * 新增商品
     * @param goods
     */
    @Insert("insert into goods(name,price,sup_type,sub_type,isRecommend,sex,image,age)" +
            "values(#{name},#{price},#{supType},#{subType},#{isRecommend},#{sex},#{image},#{age}) ")
    void addGood(Goods goods);

    /**
     * 删除商品
     * @param id
     */
    @Delete("delete from goods where id=#{id}")
    void deleteOneGood(Integer id);

    /**
     * 更新商品
     * @param goods
     */
    @Update({
            "<script>",
            "UPDATE  goods",
            "<set>",

            "<if test='name != null'>",
            " name = #{name}",
            "</if>",

            "<if test='sex != null'>",
            "sex = #{sex}",
            "</if>",

            "<if test='age != null'>",
            "age = #{age}",
            "</if>",

            "<if test='isRecommend != null'>",
            "isRecommend = #{isRecommend}",
            "</if>",

            "</set>",
            "where id=#{id}",
            "</script>"})
    void update(Goods goods);
}
