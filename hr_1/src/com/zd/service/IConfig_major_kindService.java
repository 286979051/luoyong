package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major_kind;

public interface IConfig_major_kindService {
	
	
	//职业分类一级联动
	public List<Config_major_kind> majorQuery();
	//职业分类一级联动单查
	public Config_major_kind majorQueryDan(int id);
	//张紫行，查询所有职业分类
	public List<Config_major_kind> majorkindlist();
	//张紫行，删除职业分类
	public void deletemajorkind(String major_kind_id);
	//张紫行，添加职业分类
	public void addmajorkind(Config_major_kind majorkind);
	
}
