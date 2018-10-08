package com.zd.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IConfig_public_charservice;

@Controller
public class Config_major_kindController {

	@Autowired
	private IConfig_major_kindService config_major_kindService;
	@Autowired
	private IConfig_public_charservice config_public_charservice;
	@RequestMapping("majorQuery")
	public String majorQuery(Map map) {
		List<Config_major_kind> major = config_major_kindService.majorQuery();
		List<Config_public_char> publicList = config_public_charservice.QueryEngageType();
		List<Config_public_char> GuoJi = config_public_charservice.QueryEngageGuoJi();
		List<Config_public_char> MinZu = config_public_charservice.QueryEngageMinZu();
		List<Config_public_char> ZongJiao = config_public_charservice.QueryEngageZongJiao();
		List<Config_public_char> MianMao = config_public_charservice.QueryEngageMianMiao();
		List<Config_public_char> all = config_public_charservice.queryall();
		map.put("all", all);
		map.put("major", major);
		map.put("publicList", publicList);
		map.put("GuoJi", GuoJi);
		map.put("MinZu", MinZu);
		map.put("ZongJiao", ZongJiao);
		map.put("MianMao", MianMao);
		return "recruit/resume/register";
	}
}
