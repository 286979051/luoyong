package com.zd.service;

import org.springframework.stereotype.Service;

import com.zd.entity.user;

@Service
public interface IUserService {
	//µÇÂ¼
	public user login(user u);
}
