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
}
