package com.zd.service;

import java.util.List;

import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;

public interface IConfig_majorService {

	//ְҵ����������� 
	public List<Config_major> ErMajorQuery(int id);
	
	//ְҵ���������������
	public Config_major ErMajorQueryDan(int id);
	
	//�����У���ѯ����ְλ
	public List<Config_major> selallConfig_major();
	
	//�����У�ɾ��ְλ
	public void deletemajor(int makid);
	
	//�����У����ְλ
	public void addConfig_major(Config_major Configmajor);
	
	//�����У�����ְλ����id��ѯְλ����
	public Config_major_kind majorkindname(String majorkindid);
}
