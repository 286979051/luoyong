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
	//��������
	public List<Config_file_second_kind> queryById(String id) {
		return config_file_second_kindDao.queryById(id);
	}
	
	//��ѯ���ж�������
	public List<Config_file_second_kind> selall() {
		return config_file_second_kindDao.selall();
	}

	//���֮ǰ��ѯ���е�һ������
	public List<Config_file_first_kind> selallfirstname() {
		return config_file_second_kindDao.selallfirstname();
	}

	//��Ӷ�������
	public void addsecond(Config_file_second_kind secondkind) {
		config_file_second_kindDao.addsecond(secondkind);
	}
	
	//������������
	public Config_file_second_kind queryDan(String id) {
		return config_file_second_kindDao.queryDan(id);
	}

	//�޸Ķ�������ǰ����ѯ
	public Config_file_second_kind selbyfskid(int fskid) {
		return config_file_second_kindDao.selbyfskid(fskid);
	}

	//�޸Ķ�������
	public void updatesecondkind(Config_file_second_kind secondkind) {
		config_file_second_kindDao.updatesecondkind(secondkind);
	}

	//ɾ����������
	public void deletesecond(String secondkindid) {
		config_file_second_kindDao.deletesecond(secondkindid);
	}

	//��ѯ����������������ѯ�������������
	public Config_file_second_kind selbysecondkindid(String secondkindid) {
		return config_file_second_kindDao.selbysecondkindid(secondkindid);
	}

	//ɾ������������ͬʱɾ����������
	public void delete2(String secondkindid) {
		config_file_second_kindDao.delete2(secondkindid);
	}



}
