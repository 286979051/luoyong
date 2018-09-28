
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
import com.zd.service.IConfig_file_second_kindService;

@Controller
public class Config_file_second_kindController {
	//��־����
	 Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private IConfig_file_second_kindService config_file_second_kindService;
	//��������
	@RequestMapping("queryById")
	@ResponseBody
	public List<Config_file_second_kind> queryById(String id){
		List<Config_file_second_kind> secondList = config_file_second_kindService.queryById(id);
		return secondList;
	}
	
	//��ѯ���ж�������
	//������
	@RequestMapping("/selallsecondkind")
	public String selallsecondkind(Map map) {
		try {
			List<Config_file_second_kind> secondkindlist = config_file_second_kindService.selall();
			map.put("secondkindlist", secondkindlist);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return "/client/second_kind";
	}
	
	//���֮ǰ��ѯ����һ������������
	@RequestMapping("selallfirstname")
	public String selallfirstname(Map map){
		try {
			List<Config_file_first_kind> namelist = config_file_second_kindService.selallfirstname();
			map.put("namelist", namelist);
			long systime = System.currentTimeMillis();
			map.put("systime", systime);
		} catch (Exception e) {
			logger.error("ʧ��",e);
		}
		return "/client/second_kind_register";
	}
	
	//��Ӷ�������
	@RequestMapping("addsecond")
	public String addsecond(Config_file_second_kind secondkind){
		try {
			config_file_second_kindService.addsecond(secondkind);
		} catch (Exception e) {
			logger.error("ʧ��",e);
		}
		return"/client/second_kind_register_success";
	}
	
}
