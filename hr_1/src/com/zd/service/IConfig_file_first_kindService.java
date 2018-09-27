package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Config_file_first_kind;

public interface IConfig_file_first_kindService {

	//一级机构联动
	public List<Config_file_first_kind> query();
	//添加一级机构
	public void add(Config_file_first_kind firstkind);
	//修改之前做查询
	public Config_file_first_kind selbyffkid(int ffkid);
	//修改
	public void update(Config_file_first_kind firstkind);
	//删除
	public void delete(int ffkid);

	
	//一级机构联动单条查询
	public Config_file_first_kind queryDan(int first_kind_id);
}
