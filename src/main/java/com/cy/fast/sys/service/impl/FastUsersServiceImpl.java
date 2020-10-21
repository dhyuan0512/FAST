package com.cy.fast.sys.service.impl;

import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.fast.common.exception.ServiceException;
import com.cy.fast.sys.dao.FastUserDao;
import com.cy.fast.sys.entity.SysUser;
import com.cy.fast.sys.service.FastUsersService;
@Service
public class FastUsersServiceImpl implements FastUsersService{
	@Autowired
	private FastUserDao fastUserDao;

	@Override
	public int saveObjet(SysUser entity) {
		//1.判断参数
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getUsername()))
			throw new IllegalArgumentException("用户名不能为空");
		SysUser user=fastUserDao.findUserByUserName(entity.getUsername());
		if(user!=null)throw new ServiceException("用户名已存在");
		if(StringUtils.isEmpty(entity.getPassword()))
		throw new ServiceException("密码不能为空");
		if(StringUtils.isEmpty(entity.getEmail()))
		throw new ServiceException("邮箱不能为空");	
		if(StringUtils.isEmpty(entity.getMobile()))
		throw new ServiceException("手机号不能为空");	
		//2.写入信息
		String salt = UUID.randomUUID().toString();
		SimpleHash sh = new SimpleHash("MD5",entity.getPassword(),salt,1);
		entity.setSalt(salt);
		entity.setPassword(sh.toHex());
		entity.setValid(1);
		int rows = fastUserDao.insertObject(entity);
		return rows;
	}

	@Override
	public String findNameByName(String name) {
		
		return fastUserDao.findNameByName(name);
	}

	
	
	

}
