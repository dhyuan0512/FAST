package com.cy.fast.sys.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 *定义项目的页面 
 *
 */
@Controller
@RequestMapping("/")
public class PageController {
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
	}
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
	@RequestMapping("doLogUI")
	public String doLogUI() {
		return "ajax/log";
	}
	@RequestMapping("doLoginUI")
	public String doLoginUI(){
			return "login";
	}
	@RequestMapping("index")
	public String doIndex() {
		return "index";	
	}
	@RequestMapping("login1")
	public String doLogin() {
		return "login1";
	}
	@RequestMapping("shop_cart")
	public String doShopCart() {
		return "shop/shop_cart";
	}
	@RequestMapping("/sss")
	public String doSsousu() {
		return "sss";
	}
	//优化打开界面返回UI
	//rest风格
	@RequestMapping("{module}/{moduleUI}")
	public String doMenuUI(@PathVariable String moduleUI) {
		return "sys/"+moduleUI;
	}
}
