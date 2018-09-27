package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_public_charDao;
import com.zd.entity.Config_public_char;
import com.zd.service.IConfig_public_charservice;

@Service
public class Config_public_charservice implements IConfig_public_charservice {
	@Autowired
	private IConfig_public_charDao Config_public_char;
	
	//查询所有类型
	public List<Config_public_char> queryall() {
		return Config_public_char.queryall();
	}

	
	//查询招聘类型
	public List<Config_public_char> QueryEngageType() {
		return Config_public_char.QueryEngageType();
	}

}
