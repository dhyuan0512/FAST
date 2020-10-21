package com.cy.shop.cart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.fast.sys.dao.ShopCartDao;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShopCartDaoTests {
	
	@Autowired
	ShopCartDao shopCartDao;
	
	@Test
	// 根据用户id从数据库查找属于该用户的全部“用户-商品”关系
	public void TestFindCart() {
		System.out.println(shopCartDao.findCarts(1));
	}
	
	@Test
	// 向目标用户购物车中添加指定类型及数量的商品
	public void TestAddProd() {
		System.out.println(shopCartDao.addProd(1, 1, 30));
	}
	
	@Test
	// 增加目标用户购物车中指定类型商品的数量
	public void TestIncreaseProdAmount() {
		System.out.println(shopCartDao.increaseProdAmount(1, 1, 40));
	}
	
	@Test
	// 修改目标用户购物车中指定类型商品的数量
	public void TestUpdateProdAmount() {
		System.out.println(shopCartDao.updateProdAmount(1, 1, 20));
	}
	
	@Test
	// 查找目标用户购物车中指定类型的商品信息
	public void TestFindById() {
		System.out.println(shopCartDao.findById(1, 1));
	}
	
	@Test
	// 验证目标用户购物车中是否已存在指定类型商品
	public void TestGetUserProdCount() {
		System.out.println(shopCartDao.getUserProdCount(1, 1));
	}

}
