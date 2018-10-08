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
	
	//ְҵ����������� 
	public List<Config_major> ErMajorQuery(String id) {
		return config_majorDao.ErMajorQuery(id);
	}

	//ְҵ���������������
	public Config_major ErMajorQueryDan(String id) {
		return config_majorDao.ErMajorQueryDan(id);
	}

	//�����У���ѯ����ְλ
	public List<Config_major> selallConfig_major() {
		return config_majorDao.selallConfig_major();
	}

	//�����У�ɾ��ְλ
	public void deletemajor(int makid) {
		config_majorDao.deletemajor(makid);
	}

	//�����У����ְλ
	public void addConfig_major(Config_major Configmajor) {
		config_majorDao.addConfig_major(Configmajor);
	}
	
	//�����У�����ְλ����id��ѯְλ����
		public Config_major_kind majorkindname(String majorkindid) {
			return config_majorDao.majorkindname(majorkindid);
		}

		@Override
		public Config_major ErMajorQueryDan(int id) {
			// TODO Auto-generated method stub
			return null;
		}

}
