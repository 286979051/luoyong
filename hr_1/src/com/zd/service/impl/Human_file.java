package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IHuman_fileDao;
import com.zd.entity.Config_shang;
import com.zd.service.IHuman_fileservice;

@Service
public class Human_file implements IHuman_fileservice {
	@Autowired
	private IHuman_fileDao human_file;
	//���
	public void add(com.zd.entity.Human_file humman_file) {
		human_file.add(humman_file);
	}
	//��ѯΪ����
	public List<com.zd.entity.Human_file> Humanfileselall(){
		return human_file.Humanfileselall();
	}
	
	public void update(Config_shang shang) {
		human_file.update(shang);
	}
	//�޸�
	public void human_chack_update(com.zd.entity.Human_file humman_file) {
		human_file.human_chack_update(humman_file);
	}
	//��������ѯ
	public List<com.zd.entity.Human_file> query_list(Map map){
		return human_file.query_list(map);
	}
	//���ݵ����Ų�ѯ
	public com.zd.entity.Human_file Humanfileidselall(String human_id){
		return human_file.Humanfileidselall(human_id);
	}
	//��ѯ����
	public List<com.zd.entity.Human_file> Humanfileallsel(){
		return human_file.Humanfileallsel();
	}
	//�޸ı��
	public void human_chack_upd(com.zd.entity.Human_file humman_file) {
		human_file.human_chack_upd(humman_file);
	}
	//ɾ��������ѯ
	public List<com.zd.entity.Human_file> delete_list(Map map){
		return human_file.delete_list(map);
	}
	//����ɾ��
	public void delete_update(String human_id) {
		human_file.delete_update(human_id);
	}
}
