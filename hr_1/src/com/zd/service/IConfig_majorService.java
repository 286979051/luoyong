package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major;

public interface IConfig_majorService {

	//ְҵ����������� 
	public List<Config_major> ErMajorQuery(int id);
	
	//ְҵ���������������
	public Config_major ErMajorQueryDan(int id);
}