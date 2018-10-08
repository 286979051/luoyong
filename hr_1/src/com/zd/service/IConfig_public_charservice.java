package com.zd.service;

import java.util.List;

import org.springframework.stereotype.Service;
/**
 * 公共表service
 */
import com.zd.entity.Config_public_char;

@Service
public interface IConfig_public_charservice {
	//查询所有类型
	public List<Config_public_char> queryall();
	
	//zhangmin的查询薪酬公共字段
	public List<Config_public_char> selsalary();
	
	//zhangmin的查询薪酬公共字段（一对一）
	public List<Config_public_char> selzm_some(int pbc_id);
		
	//查询招聘类型
	public List<Config_public_char> QueryEngageType();
	
	//查询招聘类型单查
	public Config_public_char QueryEngageTypeDan(int id);
	
	//张紫行，查询所有职称
	public List<Config_public_char> selprofessiondesign();
	//张紫行，删除职称
	public void deleteprofession(int pbc_id);
	//张紫行，查询所有公共属性
	public List<Config_public_char> selallpublicchar();
	//张紫行，删除公共属性
	public void deletepublicchar(int pbc_id);
	//张紫行，添加公共属性
	public void addConfigpublicchar(Config_public_char publicchar);
	//张紫行，查询所有的薪酬设置
	public List<Config_public_char> salaryitemlist();
	//张紫行，删除薪酬设置
	public void deletesalaryitem(int pbc_id);
	//张紫行，添加薪酬设置
	public void addsalaryitem(Config_public_char publicchar);
}
