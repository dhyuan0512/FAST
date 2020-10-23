package com.cy.fast.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.fast.common.exception.ServiceException;
import com.cy.fast.sys.dao.ShopCartDao;
import com.cy.fast.sys.dao.ShopProdDao;
import com.cy.fast.sys.entity.ShopCart;
import com.cy.fast.sys.entity.ShopProd;
import com.cy.fast.sys.service.ShopCartService;
import com.cy.fast.sys.vo.ShopCartVo;

@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private ShopCartDao shopCartDao;

    @Autowired
    private ShopProdDao shopProdDao;

    @Override
    public List<ShopCartVo> findShopCart(Integer userId) {
        // 1.判断参数合法性
        // 1)判断参数为空
        if (userId == null || userId < 0)
            throw new ServiceException("用户id无效");

        // 2.根据userId，获取属于目标用户的shopCart集合
        List<ShopCart> shopCarts = shopCartDao.findCarts(userId);

        // 3.将shopCart集合转化为shopCartVo集合
        List<ShopCartVo> shopCartVos = new ArrayList<ShopCartVo>();// 保存最终的shopCartVo集合
        ShopProd shopProd;// 根据shopCarts中的商品id获取shopProd实体，用于将其中的商品信息传入shopCartVo
        for (ShopCart shopCart : shopCarts) {
            shopProd = shopProdDao.findById(shopCart.getProdId());
            shopCartVos.add(new ShopCartVo(// 通过ShopCartVo的构造函数将商品信息传入
                    shopProd.getId(),
                    shopProd.getName(),
                    shopProd.getDescribe(),
                    shopProd.getPrice(),
                    shopCart.getAmount(),
                    shopProd.getItemPic()));
        }
        // 4.返回shopCartVo集合
        return shopCartVos;
    }

    @Override
    public int addProd(Integer userId, Integer prodId, Integer amount) {
        // 1.判断参数合法性
        // 1)判断参数是否为空
        if (userId == null || userId < 0)
            throw new ServiceException("用户id无效");
        if (prodId == null || prodId < 0)
            throw new ServiceException("商品id无效");
        if (amount == null || amount < 1)
            throw new ServiceException("商品数量无效");

        // 2.查看购物车中是否已存在此类商品：若存在，则修改此类商品数量，否则新增此类商品
        int rows = 0;
        if (shopCartDao.getUserProdCount(userId, prodId) == 1) {
            rows = shopCartDao.increaseProdAmount(userId, prodId, amount);
        } else {
            rows = shopCartDao.addProd(userId, prodId, amount);
        }

        // 3.返回修改行数
        return rows;
    }

    @Override
    public int changeProdAmount(Integer userId, Integer prodId, Integer amount) {
        // 1.判断参数合法性
        // 1)判断参数是否为空
        if (userId == null || userId < 0)
            throw new ServiceException("用户id无效");
        if (prodId == null || prodId < 0)
            throw new ServiceException("商品id无效");
        if (amount == null || amount < 0)
            throw new ServiceException("商品数量无效");

        // 2.修改指定商品数量，并返回修改行数
        return shopCartDao.updateProdAmount(userId, prodId, amount);
    }

    @Override
    public int deleteProd(Integer userId, Integer prodId) {
        // 1.判断参数合法性
        // 1)判断参数是否为空
        if (userId == null || userId < 0)
            throw new ServiceException("用户id无效");
        if (prodId == null || prodId < 0)
            throw new ServiceException("商品id无效");

        // 2.删除指定商品，并返回修改行数
        return shopCartDao.deleteProd(userId, prodId);
    }

}
