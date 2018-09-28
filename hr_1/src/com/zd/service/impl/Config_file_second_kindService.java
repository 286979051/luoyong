package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_second_kindDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.service.IConfig_file_second_kindService;

@Service
public class Config_file_second_kindService implements IConfig_file_second_kindService{

	@Autowired
	private IConfig_file_second_kindDao config_file_second_kindDao;
	//二级联动
	public List<Config_file_second_kind> queryById(int id) {
		return config_file_second_kindDao.queryById(id);
	}
	
	//查询所有二级机构
	public List<Config_file_second_kind> selall() {
		return config_file_second_kindDao.selall();
	}

	//添加之前查询所有的一级机构
	public List<Config_file_first_kind> selallfirstname() {
		return config_file_second_kindDao.selallfirstname();
	}

	//添加二级机构
	public void addsecond(Config_file_second_kind secondkind) {
		config_file_second_kindDao.addsecond(secondkind);
	}
	//二级联动单查
	public Config_file_second_kind queryDan(int id) {
		return config_file_second_kindDao.queryDan(id);
	}

}
