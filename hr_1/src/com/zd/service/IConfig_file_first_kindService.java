package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_first_kind;

public interface IConfig_file_first_kindService {

	//һ����������
	public List<Config_file_first_kind> query();
	//���һ������
	public void add(Config_file_first_kind firstkind);
	//�޸�֮ǰ����ѯ
	public Config_file_first_kind selbyffkid(int ffkid);
	//�޸�
	public void update(Config_file_first_kind firstkind);
	//ɾ��һ������
	public void delete(String firstkindid);
	//ɾ��һ��������ͬʱɾ����������
	public void delete2(String firstkindid);
	//ɾ��һ��������ͬʱɾ��������������������
	public void delete3(String firstkindid);
	//һ����������������ѯ
	public Config_file_first_kind queryDan(int first_kind_id);
	//���ʱ��ѯһ����������
	public Config_file_first_kind selbybhid(String firstkindid);
	public Config_file_first_kind queryDan(String first_kind_id);
}
