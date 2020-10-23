package com.cy.fast.sys.service;

import java.util.Map;

import com.cy.fast.common.vo.PageObject;
import com.cy.fast.sys.entity.SysUser;
import com.cy.fast.sys.vo.SysUserDeptVo;

public interface SysUserService {

    int updatePassword(String password, String newPassword, String cfgPassword);

    int updateObject(SysUser entity, Integer[] roleIds);

    Map<String, Object> findObjectById(Integer userId);

    int saveObject(SysUser entity, Integer[] roleIds);

    int validById(Integer id, Integer valid, String modifiedUser);

    PageObject<SysUserDeptVo> findPageObjects(String username, Integer pageCurrent);

}
