package com.zd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	//人员表的service
	@Autowired
	private IHuman_fileservice Human_fileservice;
	//人员档案表
	@Autowired
	private com.zd.service.IHuman_fileservice IHuman_fileservice;
	
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
	//跳转上传页面
	@RequestMapping("/register_choose")
	public String register_choose(Human_file human_file,Map map) {
		try {
			Salary_standard_details selSalaryone = standardService.selSalaryone(human_file.getSalary_standard_name());
			String standard_id = selSalaryone.getStandard_id();
			String standard_name = selSalaryone.getStandard_name();
			human_file.setSalary_standard_name(standard_name);
			human_file.setSalary_standard_id(standard_id);
		Human_fileservice.human_chack_update(human_file);
		map.put("human_id", human_file.getHuman_id());
		} catch (Exception e) {
			logger.error("跳转上传页面", e);
		}
		return "humanResources/register_choose_picture";
	}
	//跳转查询页面
	@RequestMapping("/query_locate")
	public String query_locate(Map map) {
		try {
		List<com.zd.entity.Config_file_first_kind> query = Config_file_first_kind.query();
		List<Config_major_kind> majorQuery = Config_major_kindService.majorQuery();
		map.put("arr", query);
		map.put("arr1", majorQuery);
		} catch (Exception e) {
			logger.error("跳转查询页面", e);
		}
		return "humanResources/query_locate";
	}
	//条件查询
	@RequestMapping("/query_list")
	public String query_list(@RequestParam Map map,Map reqestmap) {
		try {
		String startDate = (String) map.get("utilBean.startDate");
		String endDate = (String) map.get("utilBean.endDate");
		
		SimpleDateFormat aDate=new SimpleDateFormat("yyyy-mm-dd");
		Date startDate1 = aDate.parse(startDate);
		Date endDate1 = aDate.parse(endDate);
		map.put("startDate", startDate1);
		map.put("endDate", endDate1);
		List<Human_file> query_list = Human_fileservice.query_list(map);
		reqestmap.put("arr", query_list);
		} catch (Exception e) {
			logger.error("条件查询", e);
		}
		return "humanResources/query_list";
	}
	@RequestMapping("/query_list_information")
	public String query_list_information(Map map,String human_id) {
		Human_file humanfileidselall = Human_fileservice.Humanfileidselall(human_id);
		map.put("arr", humanfileidselall);
		return "humanResources/query_list_information";
	}
	//删除的信息显示
	@RequestMapping("/delete_list_information")
	public String delete_list_information(Map map,String human_id) {
		Human_file humanfileidselall = Human_fileservice.Humanfileidselall(human_id);
		map.put("arr", humanfileidselall);
		return "humanResources/delete_list_information";
	}
	
	@RequestMapping("/change_list_information")
	public String change_list_information(Map map,String human_id) {
		List<Human_file> human_fileselall = IHuman_fileservice.Humanfileallsel();
		List<Config_public_char> queryall = Config_public_charservice.queryall();
		List<Salary_standard_details> selallSalary = standardService.selSalaryall();
		map.put("arr2", selallSalary);
		map.put("arr1", queryall);
		map.put("human_id", human_id);
		map.put("arr", human_fileselall);
		return "humanResources/change_list_information";
	}
	
	//跳转变更页面
	@RequestMapping("/registerchoose")
	public String registerchoose(Human_file human_file,Map map) {
		try {
			Salary_standard_details selSalaryone = standardService.selSalaryone(human_file.getSalary_standard_name());
			String standard_id = selSalaryone.getStandard_id();
			String standard_name = selSalaryone.getStandard_name();
			human_file.setSalary_standard_name(standard_name);
			human_file.setSalary_standard_id(standard_id);
			Human_fileservice.human_chack_upd(human_file);
			map.put("human_id", human_file.getHuman_id());
			} catch (Exception e) {
				logger.error("跳转上传页面", e);
			}
			return "humanResources/register_choose_picture";
		}
}
