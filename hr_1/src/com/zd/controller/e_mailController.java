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
	//日志对象
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private Ie_mailService e_mailService;
	
	//查询所有电子邮件模板
	@RequestMapping("selalle_mail")
	public String selalle_mail(Map map) {
		try {
			List<e_mail> emaillist = e_mailService.selalle_mail();
			map.put("emaillist", emaillist);
		} catch (Exception e) {
			logger.error("失败",e);
		}
		return"/client/ShowE-mail";
	}
	
	//删除电子邮件模板
	@RequestMapping("delete_mail")
	@ResponseBody
	public String delete_mail(int e_id) {
		try {
			e_mailService.delete_mail(e_id);
		} catch (Exception e) {
			logger.error("失败",e);
		}
		return"1";
	}
	
	//跳转到添加电子邮件页面,添加之前查询所有电子模板类型
	@RequestMapping("toadd_email")
	public String toadd_email(Map map) {
		try {
			List<e_mail> emaillist = e_mailService.selalle_mail();
			map.put("emaillist", emaillist);
		} catch (Exception e) {
			logger.error("失败",e);
		}
		return"/client/e_mail_add";
	}
	
	//添加电子邮件模板
	@RequestMapping("adde_mail")
	public String adde_mail(e_mail email) {
		try {
			e_mailService.adde_mail(email);
		} catch (Exception e) {
			logger.error("失败",e);
		}
		return"redirect:selalle_mail";
	}
	
}
