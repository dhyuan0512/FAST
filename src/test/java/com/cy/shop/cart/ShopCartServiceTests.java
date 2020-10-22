//package com.cy.shop.cart;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.cy.fast.sys.service.ShopCartService;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class ShopCartServiceTests {
//
//	@Autowired
//	ShopCartService shopCartService;
//
//	@Test
//	// 获取购物车页面需要的全部商品信息
//	public void TsetFindShopCart() {
//		System.out.println(shopCartService.findShopCart((Integer) 1));
//	}
//
//	@Test
//	// 向购物车中添加商品
//	public void TsetAddProd() {
//		System.out.println(shopCartService.addProd(1, 2, 20));
//	}
//
//	@Test
//	// 修改购物车中指定商品的数量
//	public void TsetChangeProdAmount() {
//		System.out.println(shopCartService.changeProdAmount(1, 2, 20));
//	}
//
//	@Test
//	// 从购物车中删除商品
//	public void TsetDeleteProd() {
//		System.out.println(shopCartService.deleteProd(1, 2));
//	}
//
//}
