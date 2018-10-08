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
	
	//职业分类一级联动
	public List<Config_major_kind> majorQuery() {
		return config_major_kindDao.majorQuery();
	}

	//职业分类一级联动单查
	public Config_major_kind majorQueryDan(int id) {
		return config_major_kindDao.majorQueryDan(id);
	}

	//张紫行，查询所有职业分类
	public List<Config_major_kind> majorkindlist() {
		return config_major_kindDao.majorkindlist();
	}

	//张紫行，删除职业分类
	public void deletemajorkind(String major_kind_id) {
		config_major_kindDao.deletemajorkind(major_kind_id);
	}

	//张紫行，添加职业分类
	public void addmajorkind(Config_major_kind majorkind) {
		config_major_kindDao.addmajorkind(majorkind);
	}

}
