package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;

public interface IConfig_majorService {

	//职业分类二级联动 
	public List<Config_major> ErMajorQuery(int id);
	
	//职业分类二级联动单查
	public Config_major ErMajorQueryDan(int id);
	
	//张紫行，查询所有职位
	public List<Config_major> selallConfig_major();
	
	//张紫行，删除职位
	public void deletemajor(int makid);
	
	//张紫行，添加职位
	public void addConfig_major(Config_major Configmajor);
	
	//张紫行，根据职位分类id查询职位名称
	public Config_major_kind majorkindname(String majorkindid);
}
