package com.zd.service;

import java.util.List;
import java.util.Map;

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
	//ɾ��
	public void delete(int ffkid);

	
	//һ����������������ѯ
	public Config_file_first_kind queryDan(int first_kind_id);
}
