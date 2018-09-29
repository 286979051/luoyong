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
	
	//һ����������
	public List<Config_file_first_kind> query() {
		return config_file_first_kindDao.query();
	}

	//���һ������
	public void add(Config_file_first_kind firstkind) {
		config_file_first_kindDao.add(firstkind);
	}

	//�޸�֮ǰ����ѯ
	public Config_file_first_kind selbyffkid(int ffkid) {
		return config_file_first_kindDao.selbyffkid(ffkid);
	}

	//�޸�
	public void update(Config_file_first_kind firstkind) {
		config_file_first_kindDao.update(firstkind);
	}

	//ɾ��
	public void delete(String firstkindid) {
		config_file_first_kindDao.delete(firstkindid);
	}

	
	//һ����������������ѯ
	public Config_file_first_kind queryDan(int first_kind_id) {
		return config_file_first_kindDao.queryDan(first_kind_id);
	}

	//���ʱ��ѯһ����������
	public Config_file_first_kind selbybhid(String firstkindid) {
		return config_file_first_kindDao.selbybhid(firstkindid);
	}

	//ɾ��һ��������ͬʱɾ����������
	public void delete2(String firstkindid) {
		config_file_first_kindDao.delete2(firstkindid);
	}

	//ɾ��һ��������ͬʱɾ��������������������
	public void delete3(String firstkindid) {
		config_file_first_kindDao.delete3(firstkindid);
	}

	
}
