package com.cy.fast.sys.service;

import com.cy.fast.sys.entity.SysUser;



public interface FastUsersService {
	int saveObjet(SysUser entity);
	
	String findNameByName(String name);
	
	
}
