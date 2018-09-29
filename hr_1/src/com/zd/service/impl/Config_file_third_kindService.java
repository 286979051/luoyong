package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_file_third_kindDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.service.IConfig_file_third_kindService;

@Service
public class Config_file_third_kindService implements IConfig_file_third_kindService{

	@Autowired
	private IConfig_file_third_kindDao config_file_third_kindDao;
	//��������
	public List<Config_file_third_kind> queryById(int id) {
		return config_file_third_kindDao.queryById(id);
	}
	//������������
	public Config_file_third_kind queryDan(int id) {
		return config_file_third_kindDao.queryDan(id);
	}
	
	//��ѯ������������
	public List<Config_file_third_kind> selallthirdkind() {
		return config_file_third_kindDao.selallthirdkind();
	}
	
	//���֮ǰ��ѯ���е�һ������
	public List<Config_file_first_kind> selallfirst() {
		return config_file_third_kindDao.selallfirst();
	}
	
	//���֮ǰ��ѯ���еĶ�������
	public List<Config_file_second_kind> selallsecond() {
		return config_file_third_kindDao.selallsecond();
	}
	
	//�����������
	public void addthird(Config_file_third_kind thirdkind) {
		config_file_third_kindDao.addthirdkind(thirdkind);
	}
	
	//�޸�֮ǰ��ѯ
	public Config_file_third_kind selthirdupdate(int ftkid) {
		return config_file_third_kindDao.selthirdupdate(ftkid);
	}
	
	//�޸���������
	public void updatethird(Config_file_third_kind thirdkind) {
		config_file_third_kindDao.updatethird(thirdkind);
	}
	
	//ɾ����������
	public void deletethird(int ftkid) {
		config_file_third_kindDao.deletethird(ftkid);
	}

	
}
