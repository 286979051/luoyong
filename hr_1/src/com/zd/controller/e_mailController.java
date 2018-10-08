package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.e_mail;
import com.zd.service.Ie_mailService;

@Controller
public class e_mailController {
	//��־����
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private Ie_mailService e_mailService;
	
	//��ѯ���е����ʼ�ģ��
	@RequestMapping("selalle_mail")
	public String selalle_mail(Map map) {
		try {
			List<e_mail> emaillist = e_mailService.selalle_mail();
			map.put("emaillist", emaillist);
		} catch (Exception e) {
			logger.error("ʧ��",e);
		}
		return"/client/ShowE-mail";
	}
	
	//ɾ�������ʼ�ģ��
	@RequestMapping("delete_mail")
	@ResponseBody
	public String delete_mail(int e_id) {
		try {
			e_mailService.delete_mail(e_id);
		} catch (Exception e) {
			logger.error("ʧ��",e);
		}
		return"1";
	}
	
	//��ת����ӵ����ʼ�ҳ��,���֮ǰ��ѯ���е���ģ������
	@RequestMapping("toadd_email")
	public String toadd_email(Map map) {
		try {
			List<e_mail> emaillist = e_mailService.selalle_mail();
			map.put("emaillist", emaillist);
		} catch (Exception e) {
			logger.error("ʧ��",e);
		}
		return"/client/e_mail_add";
	}
	
	//��ӵ����ʼ�ģ��
	@RequestMapping("adde_mail")
	public String adde_mail(e_mail email) {
		try {
			e_mailService.adde_mail(email);
		} catch (Exception e) {
			logger.error("ʧ��",e);
		}
		return"redirect:selalle_mail";
	}
	
}
