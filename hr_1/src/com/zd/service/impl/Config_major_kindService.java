package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_major_kindDao;
import com.zd.entity.Config_major_kind;
import com.zd.service.IConfig_major_kindService;

@Service
public class Config_major_kindService implements IConfig_major_kindService{

	@Autowired
	private IConfig_major_kindDao config_major_kindDao;
	
	//ְҵ����һ������
	public List<Config_major_kind> majorQuery() {
		return config_major_kindDao.majorQuery();
	}

	//ְҵ����һ����������
	public Config_major_kind majorQueryDan(int id) {
		return config_major_kindDao.majorQueryDan(id);
	}

}