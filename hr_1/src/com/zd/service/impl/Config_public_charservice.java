package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_public_charDao;
import com.zd.entity.Config_public_char;
import com.zd.service.IConfig_public_charservice;

@Service
public class Config_public_charservice implements IConfig_public_charservice {
	@Autowired
	private IConfig_public_charDao Config_public_char;
	
	//��ѯ��������
	public List<Config_public_char> queryall() {
		return Config_public_char.queryall();
	}
	
	//zhangmin�Ĳ�ѯн�깫���ֶ�
	public List<Config_public_char> selsalary() {
		return Config_public_char.selsalary();
	}

	
	//��ѯ��Ƹ����
	public List<Config_public_char> QueryEngageType() {
		return Config_public_char.QueryEngageType();
	}


	
	public com.zd.entity.Config_public_char QueryEngageTypeDan(int id) {
		return Config_public_char.QueryEngageTypeDan(id);
	}

	//zhangmin�Ĳ�ѯн�깫���ֶΣ�һ��һ��
	public List<com.zd.entity.Config_public_char> selzm_some(int pbc_id) {
		return Config_public_char.selzm_some(pbc_id);
	}

	//�Ը�����Ϣ���в�ѯ���_zm
	public com.zd.entity.Config_public_char selfuhe(int pbc_id) {
		return Config_public_char.selfuhe(pbc_id);
	}
}
