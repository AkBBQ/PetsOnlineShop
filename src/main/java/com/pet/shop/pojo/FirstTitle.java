package com.pet.shop.pojo;

import lombok.Data;

/**
 * 一级标题实体类
 * @author 昂太
 *
 */

@Data
public class FirstTitle {
    /**
     * id
     */
    private Integer id;

    /**
     * 一级标题
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