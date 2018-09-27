package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;

public interface IConfig_file_second_kindService {

	//二级联动
	public List<Config_file_second_kind> queryById(int id);
	
	//查询所有二级机构
	public List<Config_file_second_kind> selall();
	
	//添加之前查询所有一级机构
	public List<Config_file_first_kind> selallfirstname();
	
	//添加二级机构
	public void addsecond(Config_file_second_kind secondkind);
}
