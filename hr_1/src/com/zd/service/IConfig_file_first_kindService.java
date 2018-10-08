package com.zd.service;

import java.util.List;

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
	//删除一级机构
	public void delete(String firstkindid);
	//删除一级机构的同时删除二级机构
	public void delete2(String firstkindid);
	//删除一级机构的同时删除二级机构和三级机构
	public void delete3(String firstkindid);
	//一级机构联动单条查询
	public Config_file_first_kind queryDan(int first_kind_id);
	//添加时查询一级机构名字
	public Config_file_first_kind selbybhid(String firstkindid);
	public Config_file_first_kind queryDan(String first_kind_id);
}
