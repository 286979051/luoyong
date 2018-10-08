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
	private IConfig_public_charDao config_public_char;
	
	//查询所有类型
	public List<Config_public_char> queryall() {
		return config_public_char.queryall();
	}

	
	//查询招聘类型
	public List<Config_public_char> QueryEngageType() {
		return config_public_char.QueryEngageType();
	}

	//查询国籍
	public List<com.zd.entity.Config_public_char> QueryEngageGuoJi() {
		return config_public_char.QueryEngageGuoJi();
	}

	//查询民族
	public List<Config_public_char> QueryEngageMinZu(){
		return config_public_char.QueryEngageMinZu();
	}
	
	//查询宗教信仰
	public List<Config_public_char> QueryEngageZongJiao(){
		return config_public_char.QueryEngageZongJiao();
	}
	
	//查询面貌
	public List<Config_public_char> QueryEngageMianMiao(){
		return config_public_char.QueryEngageMianMiao();
	}
	
	public com.zd.entity.Config_public_char QueryEngageTypeDan(int id) {
		return config_public_char.QueryEngageTypeDan(id);
	}



}
