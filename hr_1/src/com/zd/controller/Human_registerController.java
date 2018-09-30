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
 * ��Ա�����ǼǵĿ���
 * @author Administrator
 *
 */

@Controller
public class Human_registerController {
	//һ����ѯ
	@Autowired
	private IConfig_file_first_kindService Config_file_first_kind;
	//����������ѯ
	@Autowired
	private IConfig_file_second_kindService config_file_second_kindService;
	//����������ѯ
	@Autowired
	private IConfig_file_third_kindService config_file_third_kindService;
	//��ѯ���еĹ����ֶ�
	@Autowired
	private IConfig_public_charservice Config_public_charservice;
	//��ѯ����
	@Autowired
	private IConfig_major_kindService Config_major_kindService;
	//ְҵ�Ķ�������
	@Autowired
	private IConfig_majorService Config_majorService;
	//н��
	@Autowired
	private IStandardService standardService;
	@Autowired
	private IHuman_fileservice Human_fileservice;
	
	Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
	// ��ת��Ա�����Ǽ�
	@RequestMapping("/human_register")
	public String toPagehr(Map map){
		try {
			//һ����λ��ѯ
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
			logger.error("һ����λ��ѯ", e);
		}
	return "humanResources/human_register";
	}	
	//����������ѯ
	@RequestMapping("/querySecondByFirstId")
	@ResponseBody
	public List<Config_file_second_kind> querySecondByFirstId(String id){
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		List<Config_file_second_kind> secondList = config_file_second_kindService.queryById(id);
		return secondList;
	}
	//����������ѯ
	@RequestMapping("/querythirdBySecondId")
	@ResponseBody
	public List<Config_file_third_kind> querythirdBySecondId(String id){
		List<Config_file_third_kind> thirdList =  config_file_third_kindService.queryById(id);
		return thirdList;
	}
	//ְҵ�Ķ�������
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
		//һ����λ��ѯ
		List<com.zd.entity.Config_file_first_kind> query = Config_file_first_kind.query();
		List<Config_major_kind> majorQuery = Config_major_kindService.majorQuery();
		map.put("arr", query);
		map.put("arr1", majorQuery);
		return "humanResources/query_locate";
	}
}
