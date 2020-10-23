package com.cy.fast.sys.dao;

import java.util.List;
import java.util.Map;

import com.cy.fast.common.vo.Node;
import org.apache.ibatis.annotations.Mapper;


import com.cy.fast.sys.entity.SysMenu;

@Mapper
public interface SysMenuDao {


    //修改业务
    int updateObject(SysMenu entity);

    //添加业务
    int insertObject(SysMenu entity);

    List<Node> findZtreeMenuNodes();

    /**
     * 根据菜单id统计子菜单的个数
     *
     * @param id
     * @return
     */
    int getChildCount(Integer id);

    /**
     * 根据id 删除菜单
     *
     * @param id
     * @return
     */
    //删除业务
    int deleteObject(Integer id);

    List<Map<String, Object>> findObjects();
}

