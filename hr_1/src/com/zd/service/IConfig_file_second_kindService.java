package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;

public interface IConfig_file_second_kindService {

	//��������
	public List<Config_file_second_kind> queryById(int id);
	
	//��ѯ���ж�������
	public List<Config_file_second_kind> selall();
	
	//���֮ǰ��ѯ����һ������
	public List<Config_file_first_kind> selallfirstname();
	
	//��Ӷ�������
	public void addsecond(Config_file_second_kind secondkind);
	
	//������������
	public Config_file_second_kind queryDan(int id);
	
	//�޸Ķ�������ǰ����ѯ
	public Config_file_second_kind selbyfskid(int fskid);
	
	//�޸Ķ�������
	public void updatesecondkind(Config_file_second_kind secondkind);
	
	//ɾ����������
	public void deletesecond(String secondkindid);
	
	//ɾ������������ͬʱɾ����������
	public void delete2(String secondkindid);
	
	//������ѯ��������
	public  Config_file_second_kind selbysecondkindid(String secondkindid);
	
}
