package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_major_kind;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_major_kindService;


@Controller
public class Config_file_first_kindController {
	@Autowired
	private IConfig_file_first_kindService config_file_first_kindmapperService;
	@Autowired
	private IConfig_major_kindService config_major_kindService;
	
	@RequestMapping("/query")
	public String query(Map map) {
		List<Config_file_first_kind> firstList = config_file_first_kindmapperService.query();
		List<Config_major_kind> major = config_major_kindService.majorQuery();
		map.put("major", major);
		map.put("firstList", firstList);
		return "/recruit/position/position_register";
	}
}
