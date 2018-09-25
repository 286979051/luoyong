package com.zd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IUserDao;
import com.zd.entity.user;
import com.zd.service.IUserService;

@Service
public class UserService implements IUserService{
	//×¢Èëdao
	@Autowired
	private IUserDao userdao;
	//µÇÂ¼
	public user login(user u) {
		return userdao.login(u);
	}
}
