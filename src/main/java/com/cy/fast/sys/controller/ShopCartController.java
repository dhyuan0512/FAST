package com.cy.fast.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.fast.common.vo.JsonResult;
import com.cy.fast.sys.service.impl.ShopCartServiceImpl;

@Controller
@RequestMapping("/cart/")
public class ShopCartController {
    @Autowired
    ShopCartServiceImpl shopCartServiceImpl;

    /**
     * 查找目标用户购物车下保存的全部商品信息，
     * 返回ShopCartVo实体集合，
     * 每个ShopCartVo实体中只保存购物车中的一类商品的信息
     */
    @RequestMapping("doFindCart")
    @ResponseBody
    JsonResult doFindCart(Integer userId) {
        return new JsonResult(shopCartServiceImpl.findShopCart(userId));
    }

    /**
     * 向购物车中添加商品，
     * 需要指明用户id，商品id，商品总数
     */
    @RequestMapping("doAddProd")
    @ResponseBody
    public JsonResult doAddProd(Integer userId, Integer prodId, Integer amount) {
        shopCartServiceImpl.addProd(userId, prodId, amount);
        return new JsonResult("添加成功");
    }

    @RequestMapping("doDeleteProd")
    @ResponseBody
    public JsonResult doDeleteProd(Integer userId, Integer prodId) {
        shopCartServiceImpl.deleteProd(userId, prodId);
        return new JsonResult("删除成功");
    }

    /**
     * 调整购物车中指定商品数量
     */
    @RequestMapping("doChangeProdAmount")
    @ResponseBody
    public JsonResult doChangeProdAmount(Integer userId, Integer prodId, Integer amount) {
        shopCartServiceImpl.changeProdAmount(userId, prodId, amount);
        return new JsonResult("修改成功");
    }

}
