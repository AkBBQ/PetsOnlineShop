package com.pet.shop.mapper;

import com.pet.shop.model.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单详情实体类
 * @author 昂太
 *
 */
@Mapper
public interface OrderInfoMapper {

    /**
     * 新增订单详情
     * @param orderInfo 订单详情
     */
    @Insert("INSERT into order_info(order_id,gid,name,num,price)" +
            " values(#{orderId},#{gid},#{name},#{num},#{price}) ")
    void add(OrderInfo orderInfo);
}
