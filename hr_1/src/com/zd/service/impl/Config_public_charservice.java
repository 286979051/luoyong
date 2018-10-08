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
	private IConfig_public_charDao config_public_char;
	
	//��ѯ��������
	public List<Config_public_char> queryall() {
		return config_public_char.queryall();
	}

	
	//��ѯ��Ƹ����
	public List<Config_public_char> QueryEngageType() {
		return config_public_char.QueryEngageType();
	}

	//��ѯ����
	public List<com.zd.entity.Config_public_char> QueryEngageGuoJi() {
		return config_public_char.QueryEngageGuoJi();
	}

	//��ѯ����
	public List<Config_public_char> QueryEngageMinZu(){
		return config_public_char.QueryEngageMinZu();
	}
	
	//��ѯ�ڽ�����
	public List<Config_public_char> QueryEngageZongJiao(){
		return config_public_char.QueryEngageZongJiao();
	}
	
	//��ѯ��ò
	public List<Config_public_char> QueryEngageMianMiao(){
		return config_public_char.QueryEngageMianMiao();
	}
	
	public com.zd.entity.Config_public_char QueryEngageTypeDan(int id) {
		return config_public_char.QueryEngageTypeDan(id);
	}



}
