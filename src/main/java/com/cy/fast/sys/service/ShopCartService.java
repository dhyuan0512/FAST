package com.cy.fast.sys.service;

import java.util.List;

import com.cy.fast.sys.vo.ShopCartVo;

public interface ShopCartService {
    /**
     * 查找目标用户购物车下保存的全部商品信息，
     * 返回ShopCartVo实体集合，
     * 每个ShopCartVo实体中只保存购物车中的一类商品的信息
     */
    List<ShopCartVo> findShopCart(Integer userId);

    /**
     * 向目标用户购物车添加指定类型商品，
     * 需要指明用户id，商品id，商品总数
     */
    int addProd(Integer userId, Integer prodId, Integer amount);

    /**
     * 删除目标用户购物车中指定类型商品
     */
    int deleteProd(Integer userId, Integer prodId);

    /**
     * 修改标用户购物车中指定类型商品，
     * 需要指明用户id，商品id，修改后的商品数
     */
    int changeProdAmount(Integer userId, Integer prodId, Integer amount);
}
