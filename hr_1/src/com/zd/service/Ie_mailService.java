package com.zd.service;

import java.util.List;

import com.zd.entity.e_mail;

public interface Ie_mailService {
	//查询所有电子邮件模板
	public List<e_mail> selalle_mail();
	
	//删除电子邮件模板
	public void delete_mail(int e_id);
	
	//添加电子邮件模板
	public void adde_mail(e_mail email);
	
	//查询单条
	public List<e_mail> e_mailQueryDan(int id);
	
	public e_mail e_mailQuery(int id);
}
