package com.zd.service;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
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
	
	//对复核信息进行查询添加_zm
	public Config_public_char selfuhe(int pbc_id);
}
