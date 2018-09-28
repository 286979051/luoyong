package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_majorDao;
import com.zd.entity.Config_major;
import com.zd.service.IConfig_majorService;
@Service
public class Config_majorService implements IConfig_majorService {

	@Autowired
	private IConfig_majorDao config_majorDao;
	
	//职业分类二级联动 
	public List<Config_major> ErMajorQuery(int id) {
		return config_majorDao.ErMajorQuery(id);
	}

	//职业分类二级联动单查
	public Config_major ErMajorQueryDan(int id) {
		return config_majorDao.ErMajorQueryDan(id);
	}

}
