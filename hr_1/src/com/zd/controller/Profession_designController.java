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
public class Profession_designController {
	//��־����
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	//ע��service
	@Autowired
	private IConfig_public_charservice publiccharservice;
	
	//��ѯ����ְ��
	@RequestMapping("/selprofessiondesign")
	public String selprofessiondesign(Map map) {
		try {
			List<Config_public_char> professionlist = publiccharservice.selprofessiondesign();
			System.out.println(professionlist);
			map.put("professionlist", professionlist);
		} catch (Exception e) {
			logger.error("��¼ʧ��", e);
		}
		return"/client/profession_design";
	}
	
	//ɾ��ְ��
	@RequestMapping("deleteprofession")
	@ResponseBody
	public String deleteprofession(int pbc_id) {
		try {
			publiccharservice.deleteprofession(pbc_id);
		} catch (Exception e) {
			logger.error("��¼ʧ��", e);
		}
		return"1";
	}
	
	
}
