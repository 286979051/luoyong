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
	
	//查询招聘类型
	public List<Config_public_char> QueryEngageType();
	
	//查询招聘类型单查
	public Config_public_char QueryEngageTypeDan(int id);
}
