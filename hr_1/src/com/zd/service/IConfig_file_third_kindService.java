package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_third_kind;

public interface IConfig_file_third_kindService {

	//��������
	public List<Config_file_third_kind> queryById(int id);
	
	//������������
	public Config_file_third_kind queryDan(int id);
}