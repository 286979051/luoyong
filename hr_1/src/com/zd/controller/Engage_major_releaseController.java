package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Engage_major_release;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IConfig_file_third_kindService;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IConfig_public_charservice;
import com.zd.service.IEngage_major_releaseService;
@Controller
public class Engage_major_releaseController {
	@Autowired
	private IConfig_file_first_kindService config_file_first_kindService;
	@Autowired
	private IConfig_file_second_kindService config_file_second_kindService;
	@Autowired
	private IConfig_file_third_kindService config_file_third_kindService;
	@Autowired
	private IConfig_major_kindService config_major_kindService;
	@Autowired
	private IConfig_public_charservice config_public_charservice;
	@Autowired
	private IEngage_major_releaseService engage_major_releaseService;
	@Autowired
	private IConfig_majorService config_majorService;
	
	//职位发表登记表查询
	@RequestMapping("releaseQuery")
	public String releaseQuery(Map map) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			List<Engage_major_release> releaseList = engage_major_releaseService.releaseQuery();
			map.put("releaseList", releaseList);
		} catch (Exception e) {
			logger.error("职位发表登记表查询", e);
		}
		return "/recruit/position/position_change_update";
	}
	
	//职位发表登记表查询
		@RequestMapping("releaseQuery1")
		public String releaseQuery1(Map map) {
			Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
			try {
				List<Engage_major_release> releaseList = engage_major_releaseService.releaseQuery();
				map.put("releaseList", releaseList);
			} catch (Exception e) {
				logger.error("职位发表登记表查询", e);
			}
			return "/recruit/position/position_release_search";
		}
	//职位发表登记表查询单条
	@RequestMapping("releaseQueryById")
	public String releaseQueryById(int id , Map map) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			Engage_major_release release = engage_major_releaseService.releaseQueryById(id);
			List<Config_public_char> cpcList = config_public_charservice.QueryEngageType();
			map.put("release", release);
			map.put("cpcList", cpcList);
		} catch (Exception e) {
			logger.error("职位发表登记表查询单条", e);
		}
		return "/recruit/position/position_release_change";
	}
	
	//职位发表登记表修改
	@RequestMapping("releaseUpd")
	public String releaseUpd(Engage_major_release Engage_major_release,int pbc_id) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			Config_public_char cpc = config_public_charservice.QueryEngageTypeDan(pbc_id);
			Engage_major_release.setEngage_type(cpc.getAttribute_name());
			engage_major_releaseService.releaseUpd(Engage_major_release);
		} catch (Exception e) {
			logger.error("职位发表登记表修改", e);
		}
		return "redirect:releaseQuery";
	}
	
	//职位发表登记删除
	@RequestMapping("releaseDelete")
	@ResponseBody
	public String releaseDelete(int mid) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			engage_major_releaseService.releaseDelete(mid);
		} catch (Exception e) {
			logger.error("职位发表登记删除", e);
		}
		return "1";
	}
	//职位发表登记添加
	@RequestMapping("releaseInsetr")
	public String releaseInsetr(Engage_major_release Engage_major_release,String first_kind_id,String second_kind_id,String third_kind_id,int major_kind_id,int major_id,int pbc_id) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			//一级机构联动单条查询赋值
			Config_file_first_kind cffk = config_file_first_kindService.queryDan(first_kind_id);
			Engage_major_release.setFirst_kind_name(cffk.getFirstkindname());
			//二级机构联动单条查询赋值
			Config_file_second_kind cfsk =  config_file_second_kindService.queryDan(second_kind_id);
			Engage_major_release.setSecond_kind_name(cfsk.getSecondkindname());
			//三级机构联动单条查询赋值
			Config_file_third_kind cftk = config_file_third_kindService.queryDan(third_kind_id);
			Engage_major_release.setThird_kind_name(cftk.getThirdkindname());
			//职业分类一级联动单查赋值
			Config_major_kind cmk =  config_major_kindService.majorQueryDan(major_kind_id);
			Engage_major_release.setMajor_kind_name(cmk.getMajor_kind_name());
			//职业分联动类二级单查赋值
			Config_major cmajor = config_majorService.ErMajorQueryDan(major_id);
			Engage_major_release.setMajor_name(cmajor.getMajorname());
			//查询招聘类型单查赋值
			Config_public_char cpc = config_public_charservice.QueryEngageTypeDan(pbc_id);
			Engage_major_release.setEngage_type(cpc.getAttribute_name());
			engage_major_releaseService.releaseInsert(Engage_major_release);
		} catch (Exception e) {
			logger.error("职位发表登记添加", e);
		}
		return "redirect:releaseQuery";
	}
	
}
