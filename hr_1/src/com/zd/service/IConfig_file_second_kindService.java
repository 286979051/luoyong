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
	
	//二级联动单查
	public Config_file_second_kind queryDan(int id);
	
	//修改二级机构前做查询
	public Config_file_second_kind selbyfskid(int fskid);
	
	//修改二级机构
	public void updatesecondkind(Config_file_second_kind secondkind);
	
	//删除二级机构
	public void deletesecond(String secondkindid);
	
	//删除二级机构的同时删除三级机构
	public void delete2(String secondkindid);
	
	//单条查询二级机构
	public  Config_file_second_kind selbysecondkindid(String secondkindid);
	
}
