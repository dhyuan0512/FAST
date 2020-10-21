package com.cy.fast.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.fast.sys.entity.ShopCart;

@Mapper
public interface ShopCartDao {
	/**
	 * 查找目标用户购物车下保存的全部商品类型及数量，
	 * 返回ShopCart实体集合，
	 * 每个ShopCart实体中只保存购物车中的一类商品及数量
	 */
	List<ShopCart> findCarts(Integer userId);
	
	/**
	 * 查找目标用户购物车中的指定类型商品，返回一个ShopCart实体
	 */
	ShopCart findById(
			@Param("userId") Integer userId,
			@Param("prodId") Integer prodId);
	
	/**
	 * 验证目标用户购物车中是否已存在指定类型的商品，
	 * 返回1代表存在，0代表不存在
	 */
	int getUserProdCount(
			@Param("userId") Integer userId,
			@Param("prodId") Integer prodId);
	
	/**
	 * 向目标用户购物车添加指定类型商品，
	 * 需要指明用户id，商品id，商品总数
	 */
	int addProd(
			@Param("userId") Integer userId,
			@Param("prodId") Integer prodId,
			@Param("amount") Integer amount);
	
	/**
	 * 从目标用户购物车中删除指定类型商品
	 */
	int deleteProd(
			@Param("userId") Integer userId,
			@Param("prodId") Integer prodId);
	
	/**
	 * 修改目标用户购物车中指定类型商品的数量，
	 * 需要指明用户id，商品id，修改后的数量
	 */
	int updateProdAmount(
			@Param("userId") Integer userId,
			@Param("prodId") Integer prodId,
			@Param("amount") Integer amount);
	
	/**
	 * 增加目标用户购物车中指定类型商品的数量，
	 * 需要指明用户id，商品id，增加量
	 */
	int increaseProdAmount(
			@Param("userId") Integer userId,
			@Param("prodId") Integer prodId,
			@Param("increase") Integer increase);
}
