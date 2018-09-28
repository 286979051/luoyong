package com.zd.controller;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IConfig_public_charservice;


@Controller
public class Config_file_first_kindController {
	//日志对象
	 Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private IConfig_file_first_kindService config_file_first_kindmapperService;
	//罗勇
	private IConfig_file_first_kindService config_file_first_kindService;
	@Autowired
	private IConfig_major_kindService config_major_kindService;
	@Autowired
	private IConfig_public_charservice config_public_charservice;
	
	@RequestMapping("/query")
	public String query(Map map) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			List<Config_file_first_kind> firstList = config_file_first_kindService.query();
			List<Config_major_kind> major = config_major_kindService.majorQuery();
			List<Config_public_char> publicList = config_public_charservice.QueryEngageType();
			map.put("major", major);
			map.put("firstList", firstList);
			map.put("publicList", publicList);
		} catch (Exception e) {
			logger.error("三级联动", e);
		}
		return "/recruit/position/position_register";
	}
	//张紫行
	//查询一级机构
	@RequestMapping("/selallfirstkind")
	public String selallfirstkind(Map map) {
		try {
			List<Config_file_first_kind> firstList = config_file_first_kindmapperService.query();
			map.put("firstList", firstList);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return "/client/first_kind";
	}
	//跳转添加页面方法
	@RequestMapping("toadd")
	public String toadd(Map<String, Object> map){
		try {
			List<Config_file_first_kind> firstList =config_file_first_kindmapperService.query();
			map.put("firstList", firstList);
			long systime = System.currentTimeMillis();
			map.put("systime", systime);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"/client/first_kind_register";
	}
	
	//添加
	@RequestMapping("/add")
	public String add(Config_file_first_kind firstkind){
		try {
			config_file_first_kindmapperService.add(firstkind);
			System.out.println(firstkind);
		} catch (Exception e){
			logger.error("失败", e);
		}
		return "/client/first_kind_register_success";
	}
	
	//修改之前做查询
	@RequestMapping("/selbyffkid")
	public String selbyffkid(int ffkid,Map map){
		try {
			Config_file_first_kind firstkind = config_file_first_kindmapperService.selbyffkid(ffkid);
			map.put("firstkind", firstkind);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"/client/first_kind_change";
	}
	
	//修改
	@RequestMapping("/update")
	public String update(Config_file_first_kind firstkind){
		try {
			config_file_first_kindmapperService.update(firstkind);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return "/client/first_kind_change_success";
	}
	
	//删除
	@RequestMapping("/delete")
	public String delete(int ffkid){
		try {
			config_file_first_kindmapperService.delete(ffkid);
		} catch (Exception e) {
			logger.error("失败",e);
		}
		return "/client/first_delete_success";
	}
	
}
