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
	
	//��ѯ��Ƹ���͵���
	public Config_public_char QueryEngageTypeDan(int id);
	
	//�Ը�����Ϣ���в�ѯ���_zm
	public Config_public_char selfuhe(int pbc_id);
}
