package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major_kind;

public interface IConfig_major_kindService {
	
	
	//职业分类一级联动
	public List<Config_major_kind> majorQuery();
	//职业分类一级联动单查
	public Config_major_kind majorQueryDan(int id);
}
