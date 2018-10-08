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
	
	//zhangmin的查询薪酬公共字段
	public List<Config_public_char> selsalary() {
		return Config_public_char.selsalary();
	}

	
	//查询招聘类型
	public List<Config_public_char> QueryEngageType() {
		return Config_public_char.QueryEngageType();
	}


	
	public com.zd.entity.Config_public_char QueryEngageTypeDan(int id) {
		return Config_public_char.QueryEngageTypeDan(id);
	}

	//zhangmin的查询薪酬公共字段（一对一）
	public List<com.zd.entity.Config_public_char> selzm_some(int pbc_id) {
		return Config_public_char.selzm_some(pbc_id);
	}

	//对复核信息进行查询添加_zm
	public com.zd.entity.Config_public_char selfuhe(int pbc_id) {
		return Config_public_char.selfuhe(pbc_id);
	}
}
