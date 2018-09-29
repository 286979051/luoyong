package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_first_kindDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.service.IConfig_file_first_kindService;

@Service
public class Config_file_first_kindService implements IConfig_file_first_kindService{

	@Autowired
	private IConfig_file_first_kindDao config_file_first_kindDao;
	
	//一级机构联动
	public List<Config_file_first_kind> query() {
		return config_file_first_kindDao.query();
	}

	//添加一级机构
	public void add(Config_file_first_kind firstkind) {
		config_file_first_kindDao.add(firstkind);
	}

	//修改之前做查询
	public Config_file_first_kind selbyffkid(int ffkid) {
		return config_file_first_kindDao.selbyffkid(ffkid);
	}

	//修改
	public void update(Config_file_first_kind firstkind) {
		config_file_first_kindDao.update(firstkind);
	}

	//删除
	public void delete(String firstkindid) {
		config_file_first_kindDao.delete(firstkindid);
	}

	
	//一级机构联动单条查询
	public Config_file_first_kind queryDan(int first_kind_id) {
		return config_file_first_kindDao.queryDan(first_kind_id);
	}

	//添加时查询一级机构名字
	public Config_file_first_kind selbybhid(String firstkindid) {
		return config_file_first_kindDao.selbybhid(firstkindid);
	}

	//删除一级机构的同时删除二级机构
	public void delete2(String firstkindid) {
		config_file_first_kindDao.delete2(firstkindid);
	}

	//删除一级机构的同时删除二级机构和三级机构
	public void delete3(String firstkindid) {
		config_file_first_kindDao.delete3(firstkindid);
	}

	
}
