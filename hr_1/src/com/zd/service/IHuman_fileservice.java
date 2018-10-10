package com.zd.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Config_shang;
import com.zd.entity.Human_file;

public interface IHuman_fileservice {
	//���
	public void add(Human_file humman_file);
	//��ѯΪ����
	public List<Human_file> Humanfileselall();
	//�޸�ͼƬ
	public void update(Config_shang shang);
	//�޸�
	public void human_chack_update(Human_file humman_file);
	//��������ѯ
	public List<Human_file> query_list(Map map);
	//���ݵ����Ų�ѯ
	public Human_file Humanfileidselall(String human_id);
	//��ѯ����
	public List<Human_file> Humanfileallsel();
	//�޸ı��
	public void human_chack_upd(Human_file humman_file);
	//ɾ��������ѯ
	public List<Human_file> delete_list(Map map);
	//����ɾ��
	public void delete_update(String human_id);
	//ɾ���ָ���ѯ
	public List<Human_file> recovery_list(Map map);
	//�޸�
	public void recovery_update(String human_id);
	//��ѯҪɾ������Ա
	public List<Human_file> deletequery();
	//����ɾ��
	public void deletey(String id);
}
