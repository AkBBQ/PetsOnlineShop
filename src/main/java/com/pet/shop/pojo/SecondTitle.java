package com.pet.shop.pojo;

import lombok.Data;

/**
 * 二级标题实体类
 * @author 昂太
 *
 */

@Data
public class SecondTitle {
    /**
     * id
     */
    private Integer id;
    /**
     * 关联的一级标题ID
     */
    private Integer refId;

    /**
     * 二级标题
     */
    private String name;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 状态描述
     */
    private String statusDesc;
}