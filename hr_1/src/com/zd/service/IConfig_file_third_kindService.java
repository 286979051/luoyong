package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_third_kind;

public interface IConfig_file_third_kindService {

	//三级联动
	public List<Config_file_third_kind> queryById(String id);
	
	//三级联动单查
	public Config_file_third_kind queryDan(String id);
}
