package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.e_mailDao;
import com.zd.entity.e_mail;
import com.zd.service.Ie_mailService;
@Service
public class e_mailService implements Ie_mailService{
	@Autowired
	private e_mailDao e_mailDao;
	//��ѯ���е����ʼ�ģ��
	public List<e_mail> selalle_mail() {
		return e_mailDao.selalle_mail();
	}
	
	//ɾ�������ʼ�ģ��
	public void delete_mail(int e_id) {
		e_mailDao.delete_mail(e_id);
	}

	//��ӵ����ʼ�ģ��
	public void adde_mail(e_mail email) {
		e_mailDao.adde_mail(email);	
	}

}
