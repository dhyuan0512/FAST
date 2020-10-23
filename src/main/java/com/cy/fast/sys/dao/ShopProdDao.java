package com.cy.fast.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cy.fast.sys.entity.ShopProd;

@Mapper
public interface ShopProdDao {
    /**
     * 根据商品id查找商品信息
     */
    ShopProd findById(Integer prodId);
}
