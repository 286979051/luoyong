package com.zd.service;

import java.util.List;

import com.zd.entity.Config_shang;
import com.zd.entity.Human_file;

public interface IHuman_fileservice {
	//���
	public void add(Human_file humman_file);
	//��ѯ����
	public List<Human_file> Humanfileselall();
	//�޸�ͼƬ
	public void update(Config_shang shang);
	//�޸�
	public void human_chack_update(Human_file humman_file);
}
