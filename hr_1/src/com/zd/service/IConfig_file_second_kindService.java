package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_second_kind;

public interface IConfig_file_second_kindService {

	//��������
	public List<Config_file_second_kind> queryById(int id);
	
	//������������
	public Config_file_second_kind queryDan(int id);
}
