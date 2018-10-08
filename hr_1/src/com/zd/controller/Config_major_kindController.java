package com.zd.controller;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_major_kind;
import com.zd.service.IConfig_major_kindService;

@Controller
public class Config_major_kindController {
	//日志对象
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	//注入service
	@Autowired
	private IConfig_major_kindService majorkindService;
	
	//查询所有职业分类
	@RequestMapping("majorkindlist")
	public String majorkindlist (Map map) {
		try {
			List<Config_major_kind> majorkind = majorkindService.majorkindlist();
			map.put("majorkind", majorkind);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"/client/major_kind";
	}
	
	//删除职业分类
	@RequestMapping("deletemajorkind")
	@ResponseBody
	public String deletemajorkind(String major_kind_id) {
		try {
			majorkindService.deletemajorkind(major_kind_id);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"1";
	}
	
	//跳转到添加职业分类页面并且生成时间戳类型的id
	@RequestMapping("toaddmajorkind")
	public String toaddmajorkind(Map map) {
		try {
			long systime = System.currentTimeMillis();
			map.put("systime", systime);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"/client/major_kind_add";
	}
	
	//添加职业分类
	@RequestMapping("addmajorkind")
	public String addmajorkind(Config_major_kind majorkind) {
		try {
			majorkindService.addmajorkind(majorkind);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"redirect:majorkindlist";
	}
	
}
