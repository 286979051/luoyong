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
	//日志对象
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	//注入service
	@Autowired
	private IConfig_public_charservice publiccharservice;
	
	//查询所有职称
	@RequestMapping("/selprofessiondesign")
	public String selprofessiondesign(Map map) {
		try {
			List<Config_public_char> professionlist = publiccharservice.selprofessiondesign();
			System.out.println(professionlist);
			map.put("professionlist", professionlist);
		} catch (Exception e) {
			logger.error("登录失败", e);
		}
		return"/client/profession_design";
	}
	
	//删除职称
	@RequestMapping("deleteprofession")
	@ResponseBody
	public String deleteprofession(int pbc_id) {
		try {
			publiccharservice.deleteprofession(pbc_id);
		} catch (Exception e) {
			logger.error("登录失败", e);
		}
		return"1";
	}
	
	
}
