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
	//日志对象
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	//注入service
	@Autowired
	private IConfig_public_charservice public_charservice;
	
	//查询所有公共属性
	@RequestMapping("selallpublicchar")
	public String selallpublicchar(Map map) {
		try {
			List<Config_public_char> publiccharlist = public_charservice.selallpublicchar();
			map.put("publiccharlist", publiccharlist);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"/client/public_char";
	}
	
	//删除公共属性
	@RequestMapping("deletepublicchar")
	@ResponseBody
	public String deletepublicchar(int pbc_id) {
		try {
			public_charservice.deletepublicchar(pbc_id);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"1";
	}
	
	//跳转到添加页面的方法
	@RequestMapping("toaddConfigpublicchar")
	public String toaddConfigpublicchar() {
		return"/client/public_char_add";
	}
	
	//添加公共属性
	@RequestMapping("addConfigpublicchar")
	public String addConfigpublicchar(Config_public_char publicchar) {
		try {
			public_charservice.addConfigpublicchar(publicchar);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"redirect:selallpublicchar";
	}
	
	//查询所有的薪酬设置
	@RequestMapping("salaryitemlist")
	public String salaryitemlist(Map map) {
		try {
			List<Config_public_char> salaryitemlist = public_charservice.salaryitemlist();
			map.put("salaryitemlist", salaryitemlist);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"/client/salary_item";
	}
	
	//删除薪酬设置
	@RequestMapping("deletesalaryitem")
	@ResponseBody
	public String deletesalaryitem(int pbc_id) {
		try {
			public_charservice.deletesalaryitem(pbc_id);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"1";
	}
	
	//跳转添加方法
	@RequestMapping("toaddsalaryitem")
	public String toaddsalaryitem() {
		return"/client/salary_item_register";
	}
	
	//添加薪酬设置
	@RequestMapping("addsalaryitem")
	public String addsalaryitem(Config_public_char publicchar) {
		try {
			public_charservice.addsalaryitem(publicchar);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"redirect:selallpublicchar";
	}
}
