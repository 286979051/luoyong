package com.zd.service;

import java.util.List;

import org.springframework.stereotype.Service;
/**
 * ������service
 */
import com.zd.entity.Config_public_char;

@Service
public interface IConfig_public_charservice {
	//��ѯ��������
	public List<Config_public_char> queryall();
	
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
}
