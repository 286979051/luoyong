package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major_kind;

public interface IConfig_major_kindService {
	
	
	//ְҵ����һ������
	public List<Config_major_kind> majorQuery();
	//ְҵ����һ����������
	public Config_major_kind majorQueryDan(int id);
}
