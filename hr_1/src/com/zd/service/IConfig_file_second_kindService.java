package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_second_kind;

public interface IConfig_file_second_kindService {

	//二级联动
	public List<Config_file_second_kind> queryById(int id);
	
	//二级联动单查
	public Config_file_second_kind queryDan(int id);
}
