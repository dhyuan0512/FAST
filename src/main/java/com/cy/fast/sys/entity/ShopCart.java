package com.cy.fast.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ShopCart implements Serializable {

    private static final long serialVersionUID = 2515735285926942306L;

    // 一个用户完整的购物车信息，由多个ShopCart实体组成
    // 一个ShopCart实体中，只保存购物车中一类商品的id和总数

    private Integer userId;// 用户id：表示购物车属于该用户
    private Integer prodId;// 商品id：表示购物车中的一类商品
    private Integer amount;// 商品数量：购物车中此类商品的数量
    private Date addTime;// 添加日期：最近一次向购物车添加此类商品的日期

}
