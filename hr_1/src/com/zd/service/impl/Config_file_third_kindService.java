package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_third_kindDao;
import com.zd.entity.Config_file_third_kind;
import com.zd.service.IConfig_file_third_kindService;

@Service
public class Config_file_third_kindService implements IConfig_file_third_kindService{

	@Autowired
	private IConfig_file_third_kindDao config_file_third_kindDao;
	//三级联动
	public List<Config_file_third_kind> queryById(int id) {
		return config_file_third_kindDao.queryById(id);
	}

	
	
}
