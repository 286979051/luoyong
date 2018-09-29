package com.zd.service;

import java.util.List;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;

public interface IConfig_file_third_kindService {

	//��������
	public List<Config_file_third_kind> queryById(int id);
	
	//������������
	public Config_file_third_kind queryDan(int id);
	
	//��ѯ������������
	public List<Config_file_third_kind> selallthirdkind();
	
	//���֮ǰ��ѯ���е�һ������
	public List<Config_file_first_kind> selallfirst();
	
	//���֮ǰ��ѯ���еĶ�������
	public List<Config_file_second_kind> selallsecond();
	
	//�����������
	public void addthird(Config_file_third_kind thirdkind);
	
	//�޸�֮ǰ��ѯ
	public Config_file_third_kind selthirdupdate(int ftkid);
	
	//�޸�
	public void updatethird(Config_file_third_kind thirdkind);
	
	//ɾ����������
	public void deletethird(int ftkid);
}
