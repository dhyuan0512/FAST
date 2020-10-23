package com.cy.fast.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.fast.common.vo.Node;
import com.cy.fast.sys.entity.SysMenu;

public interface SysMenuService {


    List<Node> findZtreeMenuNodes();

    //修改菜单
    int updateObject(SysMenu entity);

    //添加菜单
    int saveObject(SysMenu entity);

    //删除菜单
    int deleteObject(Integer id);

    //返回数据结果
    List<Map<String, Object>> findObjects();
}


