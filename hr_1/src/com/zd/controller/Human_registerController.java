package com.zd.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_public_char;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IConfig_file_third_kindService;
import com.zd.service.IConfig_public_charservice;
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
	@Autowired
	private IConfig_public_charservice Config_public_charservice;
	
	// ��ת��Ա�����Ǽ�
	@RequestMapping("/human_register")
	public String toPagehr(Map map){
		//һ����λ��ѯ
		List<com.zd.entity.Config_file_first_kind> query = Config_file_first_kind.query();
		List<Config_public_char> queryall = Config_public_charservice.queryall();
		map.put("arr1", queryall);
		map.put("arr", query);
	return "humanResources/human_register";
	}	
	//����������ѯ
	@RequestMapping("/querySecondByFirstId")
	@ResponseBody
	public List<Config_file_second_kind> querySecondByFirstId(int id){
		List<Config_file_second_kind> secondList = config_file_second_kindService.queryById(id);
		return secondList;
	}
	//����������ѯ
	@RequestMapping("/querythirdBySecondId")
	@ResponseBody
	public List<Config_file_third_kind> querythirdBySecondId(int id){
		List<Config_file_third_kind> thirdList =  config_file_third_kindService.queryById(id);
		return thirdList;
	}
}
