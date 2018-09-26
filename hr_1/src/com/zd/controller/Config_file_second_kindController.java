
package com.zd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_file_second_kind;
import com.zd.service.IConfig_file_second_kindService;

@Controller
public class Config_file_second_kindController {

	@Autowired
	private IConfig_file_second_kindService config_file_second_kindService;
	//二级联动
	@RequestMapping("queryById")
	@ResponseBody
	public List<Config_file_second_kind> queryById(int id){
		List<Config_file_second_kind> secondList = config_file_second_kindService.queryById(id);
		return secondList;
	}
}
