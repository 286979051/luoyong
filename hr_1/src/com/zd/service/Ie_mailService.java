package com.zd.service;

import java.util.List;

import com.zd.entity.e_mail;

public interface Ie_mailService {
	//��ѯ���е����ʼ�ģ��
	public List<e_mail> selalle_mail();
	
	//ɾ�������ʼ�ģ��
	public void delete_mail(int e_id);
	
	//��ӵ����ʼ�ģ��
	public void adde_mail(e_mail email);
	
	//��ѯ����
	public List<e_mail> e_mailQueryDan(int id);
	
	public e_mail e_mailQuery(int id);
}
