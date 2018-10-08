package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_public_char;
import com.zd.service.IConfig_public_charservice;

@Controller
public class IConfig_public_charController {
	//��־����
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	//ע��service
	@Autowired
	private IConfig_public_charservice public_charservice;
	
	//��ѯ���й�������
	@RequestMapping("selallpublicchar")
	public String selallpublicchar(Map map) {
		try {
			List<Config_public_char> publiccharlist = public_charservice.selallpublicchar();
			map.put("publiccharlist", publiccharlist);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return"/client/public_char";
	}
	
	//ɾ����������
	@RequestMapping("deletepublicchar")
	@ResponseBody
	public String deletepublicchar(int pbc_id) {
		try {
			public_charservice.deletepublicchar(pbc_id);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return"1";
	}
	
	//��ת�����ҳ��ķ���
	@RequestMapping("toaddConfigpublicchar")
	public String toaddConfigpublicchar() {
		return"/client/public_char_add";
	}
	
	//��ӹ�������
	@RequestMapping("addConfigpublicchar")
	public String addConfigpublicchar(Config_public_char publicchar) {
		try {
			public_charservice.addConfigpublicchar(publicchar);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return"redirect:selallpublicchar";
	}
	
	//��ѯ���е�н������
	@RequestMapping("salaryitemlist")
	public String salaryitemlist(Map map) {
		try {
			List<Config_public_char> salaryitemlist = public_charservice.salaryitemlist();
			map.put("salaryitemlist", salaryitemlist);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return"/client/salary_item";
	}
	
	//ɾ��н������
	@RequestMapping("deletesalaryitem")
	@ResponseBody
	public String deletesalaryitem(int pbc_id) {
		try {
			public_charservice.deletesalaryitem(pbc_id);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return"1";
	}
	
	//��ת��ӷ���
	@RequestMapping("toaddsalaryitem")
	public String toaddsalaryitem() {
		return"/client/salary_item_register";
	}
	
	//���н������
	@RequestMapping("addsalaryitem")
	public String addsalaryitem(Config_public_char publicchar) {
		try {
			public_charservice.addsalaryitem(publicchar);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return"redirect:selallpublicchar";
	}
}
