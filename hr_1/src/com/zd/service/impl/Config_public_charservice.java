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
	
	//zhangmin的查询薪酬公共字段
	public List<Config_public_char> selsalary() {
		return config_public_char.selsalary();
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

	//zhangmin的查询薪酬公共字段（一对一）
	public List<com.zd.entity.Config_public_char> selzm_some(int pbc_id) {
		return config_public_char.selzm_some(pbc_id);
	}

	//对复核信息进行查询添加_zm
	public com.zd.entity.Config_public_char selfuhe(int pbc_id) {
		return config_public_char.selfuhe(pbc_id);
	}
	//张紫行,查询所有职称
	public List<Config_public_char> selprofessiondesign(){
		return config_public_char.selprofessiondesign();
	}

	//张紫行,删除职称
	public void deleteprofession(int pbc_id) {
		config_public_char.deleteprofession(pbc_id);
	}

	//张紫行，查询所有公共属性
	public List<com.zd.entity.Config_public_char> selallpublicchar() {
		return config_public_char.selallpublicchar();
	}

	//张紫行，删除公共属性
	public void deletepublicchar(int pbc_id) {
		config_public_char.deletepublicchar(pbc_id);
	}

	//张紫行，添加公共属性种类
	public void addConfigpublicchar(Config_public_char publicchar) {
		config_public_char.addConfigpublicchar(publicchar);
	}

	//张紫行，查询所有的薪酬设置
	public List<com.zd.entity.Config_public_char> salaryitemlist() {
		return config_public_char.salaryitemlist();
	}

	//张紫行，删除薪酬设置
	public void deletesalaryitem(int pbc_id) {
		config_public_char.deletesalaryitem(pbc_id);
	}

	//张紫行，添加薪酬设置
	public void addsalaryitem(com.zd.entity.Config_public_char publicchar) {
		config_public_char.addsalaryitem(publicchar);
	}
	
	


}
