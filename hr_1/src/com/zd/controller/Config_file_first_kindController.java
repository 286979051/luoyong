package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IConfig_public_charservice;


@Controller
public class Config_file_first_kindController {
	@Autowired
	private IConfig_file_first_kindService config_file_first_kindService;
	@Autowired
	private IConfig_major_kindService config_major_kindService;
	@Autowired
	private IConfig_public_charservice config_public_charservice;
	
	@RequestMapping("/query")
	public String query(Map map) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			List<Config_file_first_kind> firstList = config_file_first_kindService.query();
			List<Config_major_kind> major = config_major_kindService.majorQuery();
			List<Config_public_char> publicList = config_public_charservice.QueryEngageType();
			map.put("major", major);
			map.put("firstList", firstList);
			map.put("publicList", publicList);
		} catch (Exception e) {
			logger.error("三级联动", e);
		}
		return "/recruit/position/position_register";
	}
}
