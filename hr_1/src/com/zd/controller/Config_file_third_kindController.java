package com.zd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_file_third_kind;
import com.zd.service.IConfig_file_third_kindService;

@Controller
public class Config_file_third_kindController {
	@Autowired
	private IConfig_file_third_kindService config_file_third_kindService;
	
	
	@RequestMapping("querySanBySecondId")
	@ResponseBody
	public List<Config_file_third_kind> queryByid(String id){
		List<Config_file_third_kind> thirdList =  config_file_third_kindService.queryById(id);
		return thirdList;
	}
}
