package com.pet.shop.mapper;

import com.pet.shop.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.*;
/**
 * 订单实体类
 * @author 昂太
 *
 */
@Mapper
public interface OrderMapper {

    /**
     * 新增订单
     * @param order
     */
   @Insert("insert into orders(order_id,bid,phone,address,status,creat_time) " +
           "values(#{orderId},#{bid},#{phone},#{address},#{status},#{creatTime})")
    void add(Order order);

    /**
     * 后台查询所有订单
     */
   @Select("select o.order_id,o.bid,o.phone,o.address,o.status,o.creat_time,o.send_time,u.name from orders o ,user u where o.bid = u.id")
    List<Order> queryAllOrder(Order order);
}
