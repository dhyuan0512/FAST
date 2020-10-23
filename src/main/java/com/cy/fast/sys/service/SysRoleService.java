package com.cy.fast.sys.service;

import java.util.List;

import com.cy.fast.common.vo.PageObject;
import com.cy.fast.sys.entity.SysRole;
import com.cy.fast.sys.vo.CheckBox;
import com.cy.fast.sys.vo.SysRoleMenuVo;

public interface SysRoleService {

    List<CheckBox> findObjects();

    int updateObject(SysRole entity, Integer[] menuIds);

    SysRoleMenuVo findObjectById(Integer id);

    int saveObject(SysRole entity, Integer[] menuIds);

    int deleteObject(Integer id);

    /**
     * 本方法中要分页查询角色信息,并查询角色总记录数据
     *
     * @param pageCurrent 当表要查询的当前页的页码值
     * @return 封装当前实体数据以及分页信息
     */
    PageObject<SysRole> findPageObjects(
            String name, Integer pageCurrent);
}
