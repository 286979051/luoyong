package com.zd.service;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
/**
 * ������service
 */
import com.zd.entity.Config_public_char;

@Service
public interface IConfig_public_charservice {
	//��ѯ��������
	public List<Config_public_char> queryall();
	
	//zhangmin�Ĳ�ѯн�깫���ֶ�
	public List<Config_public_char> selsalary();
	
	//zhangmin�Ĳ�ѯн�깫���ֶΣ�һ��һ��
	public List<Config_public_char> selzm_some(int pbc_id);
		
	//��ѯ��Ƹ����
	public List<Config_public_char> QueryEngageType();
	
	//��ѯ����
	public List<Config_public_char> QueryEngageGuoJi();
	
	//��ѯ����
	public List<Config_public_char> QueryEngageMinZu();
	
	//��ѯ�ڽ�����
	public List<Config_public_char> QueryEngageZongJiao();
	
	//��ѯ��ò
	public List<Config_public_char> QueryEngageMianMiao();
	
	//��ѯ��Ƹ���͵���
	public Config_public_char QueryEngageTypeDan(int id);
	
	//�Ը�����Ϣ���в�ѯ���_zm
	public Config_public_char selfuhe(int pbc_id);
	//�����У���ѯ����ְ��
	public List<Config_public_char> selprofessiondesign();
	//�����У�ɾ��ְ��
	public void deleteprofession(int pbc_id);
	//�����У���ѯ���й�������
	public List<Config_public_char> selallpublicchar();
	//�����У�ɾ����������
	public void deletepublicchar(int pbc_id);
	//�����У���ӹ�������
	public void addConfigpublicchar(Config_public_char publicchar);
	//�����У���ѯ���е�н������
	public List<Config_public_char> salaryitemlist();
	//�����У�ɾ��н������
	public void deletesalaryitem(int pbc_id);
	//�����У����н������
	public void addsalaryitem(Config_public_char publicchar);
}
