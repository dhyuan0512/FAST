package com.cy.fast.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ShopProd implements Serializable {

	private static final long serialVersionUID = 3393890852361353908L;

	private Integer id;// 商品id
	private String name;// 商品名称
	private Double price;// 商品价格
	private Integer amount;// 商品库存
	private Date createTime;// 商品上架时间
	private String describe;// 商品描述
	private String itemPic;// 商品缩略图地址
	private String describePicFolder;// 商品描述图片文件夹地址
	
}
