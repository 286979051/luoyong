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
	
	//zhangmin�Ĳ�ѯн�깫���ֶ�
	public List<Config_public_char> selsalary() {
		return config_public_char.selsalary();
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

	//zhangmin�Ĳ�ѯн�깫���ֶΣ�һ��һ��
	public List<com.zd.entity.Config_public_char> selzm_some(int pbc_id) {
		return config_public_char.selzm_some(pbc_id);
	}

	//�Ը�����Ϣ���в�ѯ���_zm
	public com.zd.entity.Config_public_char selfuhe(int pbc_id) {
		return config_public_char.selfuhe(pbc_id);
	}
	//������,��ѯ����ְ��
	public List<Config_public_char> selprofessiondesign(){
		return config_public_char.selprofessiondesign();
	}

	//������,ɾ��ְ��
	public void deleteprofession(int pbc_id) {
		config_public_char.deleteprofession(pbc_id);
	}

	//�����У���ѯ���й�������
	public List<com.zd.entity.Config_public_char> selallpublicchar() {
		return config_public_char.selallpublicchar();
	}

	//�����У�ɾ����������
	public void deletepublicchar(int pbc_id) {
		config_public_char.deletepublicchar(pbc_id);
	}

	//�����У���ӹ�����������
	public void addConfigpublicchar(Config_public_char publicchar) {
		config_public_char.addConfigpublicchar(publicchar);
	}

	//�����У���ѯ���е�н������
	public List<com.zd.entity.Config_public_char> salaryitemlist() {
		return config_public_char.salaryitemlist();
	}

	//�����У�ɾ��н������
	public void deletesalaryitem(int pbc_id) {
		config_public_char.deletesalaryitem(pbc_id);
	}

	//�����У����н������
	public void addsalaryitem(com.zd.entity.Config_public_char publicchar) {
		config_public_char.addsalaryitem(publicchar);
	}
	
	


}
