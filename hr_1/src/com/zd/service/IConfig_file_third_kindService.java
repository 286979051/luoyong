package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;

public interface IConfig_file_third_kindService {

	//三级联动
	public List<Config_file_third_kind> queryById(int id);
	
	//三级联动单查
	public Config_file_third_kind queryDan(int id);
	
	//查询所有三级机构
	public List<Config_file_third_kind> selallthirdkind();
	
	//添加之前查询所有的一级机构
	public List<Config_file_first_kind> selallfirst();
	
	//添加之前查询所有的二级机构
	public List<Config_file_second_kind> selallsecond();
	
	//添加三级机构
	public void addthird(Config_file_third_kind thirdkind);
	
	//修改之前查询
	public Config_file_third_kind selthirdupdate(int ftkid);
	
	//修改
	public void updatethird(Config_file_third_kind thirdkind);
	
	//删除三级机构
	public void deletethird(int ftkid);
}
