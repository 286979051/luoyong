package com.zd.controller;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_file_first_kind;
import com.zd.service.IConfig_file_first_kindService;


@Controller
public class Config_file_first_kindController {
	//��־����
	 Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private IConfig_file_first_kindService config_file_first_kindmapperService;
	//����
	@RequestMapping("/query")
	public String query(Map map) {
		List<Config_file_first_kind> firstList = config_file_first_kindmapperService.query();
		map.put("firstList", firstList);
		return "/recruit/position/position_register";
	}
	//������
	//��ѯһ������
	@RequestMapping("/selallfirstkind")
	public String selallfirstkind(Map map) {
		try {
			List<Config_file_first_kind> firstList = config_file_first_kindmapperService.query();
			map.put("firstList", firstList);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return "/client/first_kind";
	}
	//��ת���ҳ�淽��
	@RequestMapping("toadd")
	public String toadd(Map<String, Object> map){
		try {
			List<Config_file_first_kind> firstList =config_file_first_kindmapperService.query();
			map.put("firstList", firstList);
			long systime = System.currentTimeMillis();
			map.put("systime", systime);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return"/client/first_kind_register";
	}
	
	//���
	@RequestMapping("/add")
	public String add(Config_file_first_kind firstkind){
		try {
			config_file_first_kindmapperService.add(firstkind);
			System.out.println(firstkind);
		} catch (Exception e){
			logger.error("ʧ��", e);
		}
		return "/client/first_kind_register_success";
	}
	
	//�޸�֮ǰ����ѯ
	@RequestMapping("/selbyffkid")
	public String selbyffkid(int ffkid,Map map){
		try {
			Config_file_first_kind firstkind = config_file_first_kindmapperService.selbyffkid(ffkid);
			map.put("firstkind", firstkind);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return"/client/first_kind_change";
	}
	
	//�޸�
	@RequestMapping("/update")
	public String update(Config_file_first_kind firstkind){
		try {
			config_file_first_kindmapperService.update(firstkind);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return "/client/first_kind_change_success";
	}
	
	//ɾ��
	@RequestMapping("/delete")
	public String delete(int ffkid){
		try {
			config_file_first_kindmapperService.delete(ffkid);
		} catch (Exception e) {
			logger.error("ʧ��",e);
		}
		return "/client/first_delete_success";
	}
	
}
