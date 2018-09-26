package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major;

public interface IConfig_majorService {

	//职业分类二级联动 
	public List<Config_major> ErMajorQuery(int id);
	
}
