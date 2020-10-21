package com.cy.fast.sys.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 需要显示在购物车页面的商品相关信息， 
 * 每个ShopCartVo实体中只保存一类商品的信息， 
 * 多个ShopCartVo实体组成一个用户的完整购物车信息
 */
@Data
public class ShopCartVo implements Serializable {

	private static final long serialVersionUID = 5400053891743598958L;

	private Integer prodId;// 商品id
	private String prodName;// 商品名称
	private String prodDescribe;// 商品描述
	private Double prodPrice;// 商品价格
	private Integer amount;// 商品总数
	private String itemPic;// 商品微缩图地址

	public ShopCartVo(Integer prodId, String prodName, String prodDescribe, Double prodPrice, Integer amount,
			String itemPic) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodDescribe = prodDescribe;
		this.prodPrice = prodPrice;
		this.amount = amount;
		this.itemPic = itemPic;
	}

}
