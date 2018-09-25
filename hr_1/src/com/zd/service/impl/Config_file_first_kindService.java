package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_first_kindDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.service.IConfig_file_first_kindmapperService;

@Service
public class Config_file_first_kindService implements IConfig_file_first_kindmapperService{

	@Autowired
	private IConfig_file_first_kindDao config_file_first_kindDao;
	
	//一级机构联动
	public List<Config_file_first_kind> query() {
		return config_file_first_kindDao.query();
	}

	
}
