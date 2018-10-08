package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_majorDao;
import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.service.IConfig_majorService;
@Service
public class Config_majorService implements IConfig_majorService {

	@Autowired
	private IConfig_majorDao config_majorDao;
	
	//职业分类二级联动 
	public List<Config_major> ErMajorQuery(String id) {
		return config_majorDao.ErMajorQuery(id);
	}

	//职业分类二级联动单查
	public Config_major ErMajorQueryDan(String id) {
		return config_majorDao.ErMajorQueryDan(id);
	}

	//张紫行，查询所有职位
	public List<Config_major> selallConfig_major() {
		return config_majorDao.selallConfig_major();
	}

	//张紫行，删除职位
	public void deletemajor(int makid) {
		config_majorDao.deletemajor(makid);
	}

	//张紫行，添加职位
	public void addConfig_major(Config_major Configmajor) {
		config_majorDao.addConfig_major(Configmajor);
	}
	
	//张紫行，根据职位分类id查询职位名称
		public Config_major_kind majorkindname(String majorkindid) {
			return config_majorDao.majorkindname(majorkindid);
		}

		@Override
		public Config_major ErMajorQueryDan(int id) {
			// TODO Auto-generated method stub
			return null;
		}

}
