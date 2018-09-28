package com.zd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 人员档案的添加与上传的控制器
 * @author Administrator
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Human_file;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IConfig_file_third_kindService;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;

@Controller
public class Human_filecontroller {
	@Autowired
	private IConfig_file_first_kindService config_file_first_kindService;
	@Autowired
	private IConfig_file_second_kindService config_file_second_kindService;
	@Autowired
	private IConfig_file_third_kindService config_file_third_kindService;
	@Autowired
	private IConfig_major_kindService config_major_kindService;
	@Autowired
	private IConfig_majorService config_majorService;
	
	
	@RequestMapping("/register_choose_picture")
	public String register_choose_picture(Human_file Engage_major_release) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			//一级机构联动单条查询赋值
			Config_file_first_kind cffk = config_file_first_kindService.queryDan(Engage_major_release.getFirst_kind_id());
			Engage_major_release.setFirst_kind_name(cffk.getFirstkindname());
			//二级机构联动单条查询赋值
			Config_file_second_kind cfsk =  config_file_second_kindService.queryDan(Engage_major_release.getSecond_kind_id());
			Engage_major_release.setSecond_kind_name(cfsk.getSecondkindname());
			//三级机构联动单条查询赋值
			Config_file_third_kind cftk = config_file_third_kindService.queryDan(Engage_major_release.getThird_kind_id());
			Engage_major_release.setThird_kind_name(cftk.getThirdkindname());
			//职业分类一级联动单查赋值
			Config_major_kind cmk =  config_major_kindService.majorQueryDan(Engage_major_release.getHuman_major_kind_id());
			Engage_major_release.setHuman_major_kind_name(cmk.getMajor_kind_name());
			//职业分联动类二级单查赋值
			Config_major cmajor = config_majorService.ErMajorQueryDan(Engage_major_release.getHuman_major_id());
			Engage_major_release.setHunma_major_name(cmajor.getMajorname());
			
		} catch (Exception e) {
			logger.error("职位发表登记添加", e);
		}
		return "redirect:releaseQuery";
	}
}
