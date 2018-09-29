package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IConfig_file_third_kindService;

@Controller
public class Config_file_third_kindController {
	//日志对象
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private IConfig_file_third_kindService config_file_third_kindService;
	//注入二级service
	@Autowired
	private IConfig_file_second_kindService secondservice;
	//注入一级service
	@Autowired
	private IConfig_file_first_kindService firstservice;
	
	@RequestMapping("querySanBySecondId")
	@ResponseBody
	public List<Config_file_third_kind> queryByid(int id){
		List<Config_file_third_kind> thirdList =  config_file_third_kindService.queryById(id);
		return thirdList;
	}
	
	//查询所有的三级机构
	@RequestMapping("/selallthirdkind")
	public String selallthirdkind(Map map) {
		try {
			List<Config_file_third_kind> thirdlist = config_file_third_kindService.selallthirdkind();
			map.put("thirdlist", thirdlist);
			
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"/client/third_kind";
	}
	
	//跳到添加页面查询所有一级机构和二级机构
	@RequestMapping("/seladd")
	public String seladd(Map map) {
		try {
			List<Config_file_first_kind> firstlist = config_file_third_kindService.selallfirst();
			List<Config_file_second_kind> secondlist = config_file_third_kindService.selallsecond();
			long systime = System.currentTimeMillis();
			map.put("systime", systime);
			map.put("firstlist", firstlist);
			map.put("secondlist", secondlist);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"/client/third_kind_register";
	}
	
	//添加三级机构
	@RequestMapping("/addthird")
	public String addthird(Config_file_third_kind thirdkind,String firstkindid,String secondkindid) {
		try {
			Config_file_first_kind firstkind = firstservice.selbybhid(firstkindid);
			thirdkind.setFirstkindname(firstkind.getFirstkindname());
			Config_file_second_kind secondkind = secondservice.selbysecondkindid(secondkindid);
			thirdkind.setSecondkindname(secondkind.getSecondkindname());
			config_file_third_kindService.addthird(thirdkind);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"/client/third_kind_register_success";
	}
	
	//修改之前做查询
	@RequestMapping("/selthirdupdate")
	public String selthirdupdate(int ftkid,Map map) {
		try {
			Config_file_third_kind thirdkind = config_file_third_kindService.selthirdupdate(ftkid);
			map.put("thirdkind", thirdkind);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"/client/third_kind_change";
	}
	
	//修改三级机构
	@RequestMapping("/updatethird")
	public String updatethird(Config_file_third_kind thirdkind) {
		try {
			config_file_third_kindService.updatethird(thirdkind);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"/client/third_kind_change_success";
	}
	
	//删除三级机构
	@RequestMapping("/deletethird")
	public String deletethird(int ftkid) {
		try {
			config_file_third_kindService.deletethird(ftkid);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"/client/third_delete_success";
	}
}
