package com.zd.controller;

import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Human_file;
import com.zd.entity.Salary_standard_details;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IConfig_file_third_kindService;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IConfig_public_charservice;
import com.zd.service.IHuman_fileservice;
import com.zd.service.IStandardService;
/**
 * 人员档案登记的控制
 * @author Administrator
 *
 */

@Controller
public class Human_registerController {
	//一级查询
	@Autowired
	private IConfig_file_first_kindService Config_file_first_kind;
	//二级联动查询
	@Autowired
	private IConfig_file_second_kindService config_file_second_kindService;
	//三级联动查询
	@Autowired
	private IConfig_file_third_kindService config_file_third_kindService;
	//查询所有的公共字段
	@Autowired
	private IConfig_public_charservice Config_public_charservice;
	//查询分类
	@Autowired
	private IConfig_major_kindService Config_major_kindService;
	//职业的二级联动
	@Autowired
	private IConfig_majorService Config_majorService;
	//薪酬
	@Autowired
	private IStandardService standardService;
	@Autowired
	private IHuman_fileservice Human_fileservice;
	
	Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
	// 跳转人员档案登记
	@RequestMapping("/human_register")
	public String toPagehr(Map map){
		try {
			//一级单位查询
			List<com.zd.entity.Config_file_first_kind> query = Config_file_first_kind.query();
			List<Config_public_char> queryall = Config_public_charservice.queryall();
			List<Config_major_kind> majorQuery = Config_major_kindService.majorQuery();
			List<Salary_standard_details> selallSalary = standardService.selSalaryall();
			long currentTimeMillis = System.currentTimeMillis();
			map.put("currentTimeMillis", currentTimeMillis);
			map.put("arr3", selallSalary);
			map.put("arr2", majorQuery);
			map.put("arr1", queryall);
			map.put("arr", query);
		} catch (Exception e) {
			logger.error("一级单位查询", e);
		}
	return "humanResources/human_register";
	}	
	//二级联动查询
	@RequestMapping("/querySecondByFirstId")
	@ResponseBody
	public List<Config_file_second_kind> querySecondByFirstId(String id){
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		List<Config_file_second_kind> secondList = config_file_second_kindService.queryById(id);
		return secondList;
	}
	//三级联动查询
	@RequestMapping("/querythirdBySecondId")
	@ResponseBody
	public List<Config_file_third_kind> querythirdBySecondId(String id){
		List<Config_file_third_kind> thirdList =  config_file_third_kindService.queryById(id);
		return thirdList;
	}
	//职业的二级联动
	@RequestMapping("/querymajorKindById")
	@ResponseBody
	public List<Config_major> querymajorKindById(int id){
		 List<Config_major> erMajorQuery = Config_majorService.ErMajorQuery(id);
		return erMajorQuery;
	}
	
	@RequestMapping("/register_choose")
	public String register_choose(Human_file human_file,Map map) {
		Human_fileservice.human_chack_update(human_file);
		map.put("human_id", human_file.getHuman_id());
		return "humanResources/register_choose_picture";
	}
	
	@RequestMapping("/query_locate")
	public String query_locate(Map map) {
		//一级单位查询
		List<com.zd.entity.Config_file_first_kind> query = Config_file_first_kind.query();
		List<Config_major_kind> majorQuery = Config_major_kindService.majorQuery();
		map.put("arr", query);
		map.put("arr1", majorQuery);
		return "humanResources/query_locate";
	}
}
