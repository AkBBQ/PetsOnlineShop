package com.pet.shop.service;


import com.github.pagehelper.PageInfo;
import com.pet.shop.model.Order;
import com.pet.shop.model.OrderInfo;


/**
 * 订单服务类
 * @author 昂太
 *
 */
public interface OrderService {
    /**
     * 新增订单(新增订单信息)
     */
    void addIntoOrder(Order order);

    /**
     * 新增订单详情
     */
    void addOrderInfo(OrderInfo orderInfo);

    /**
     * 查看全部订单,分页查询
     */
    PageInfo<Order> queryAllOrder(Order order);


}
