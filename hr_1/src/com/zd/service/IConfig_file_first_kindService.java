package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_first_kind;

public interface IConfig_file_first_kindService {

	//一级机构联动
	public List<Config_file_first_kind> query();
	
	//一级机构联动单条查询
	public Config_file_first_kind queryDan(int first_kind_id);
}
