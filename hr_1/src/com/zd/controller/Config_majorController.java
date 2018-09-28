package com.zd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_major;
import com.zd.service.IConfig_majorService;
@Controller
public class Config_majorController {

	@Autowired
	private IConfig_majorService config_majorService;
	
	@RequestMapping("ErMajorQuery")
	@ResponseBody
	public List<Config_major> ErMajorQuery(int id){
		List<Config_major> majorlist = config_majorService.ErMajorQuery(id);
		return majorlist;
	}
}
