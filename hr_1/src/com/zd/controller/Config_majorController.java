package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;
@Controller
public class Config_majorController {
	//日志对象
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IConfig_majorService config_majorService;
	
	//注入职位分类的service,用于添加之前的查询
	@Autowired
	private IConfig_major_kindService majorkindService;
		
	
	@RequestMapping("ErMajorQuery")
	@ResponseBody
	public List<Config_major> ErMajorQuery(String id){
		List<Config_major> majorlist = config_majorService.ErMajorQuery(id);
		return majorlist;
	}
	
	//查询所有职位
	@RequestMapping("selallConfig_major")
	public String selallConfig_major(Map map) {
		try {
			List<Config_major> Config_majorlist = config_majorService.selallConfig_major();
			map.put("Config_majorlist", Config_majorlist);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"/client/major";
	}
	
	//删除职位
	@RequestMapping("deletemajor")
	@ResponseBody
	public String deletemajor(int makid) {
		try {
			config_majorService.deletemajor(makid);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"1";
	}
	
	//添加职位之前查询所有职位分类
	@RequestMapping("addmajorkindlist")
	public String majorkindlist (Map map) {
			try {
				List<Config_major_kind> majorkind = majorkindService.majorkindlist();
				map.put("majorkind", majorkind);
				long systime = System.currentTimeMillis();
				map.put("systime", systime);
			} catch (Exception e) {
				logger.error("失败", e);
			}
			return"/client/major_add";
		}
	
	//添加职位
	@RequestMapping("addConfig_major")
	public String addConfig_major(Config_major Configmajor,String majorkindid) {
		try {
			//根据职位分类id查询职位分类名称并将名称赋给添加所需名称
			Config_major_kind kindname = config_majorService.majorkindname(majorkindid);
			Configmajor.setMajorkindname(kindname.getMajor_kind_name());
			//调用添加方法执行添加
			config_majorService.addConfig_major(Configmajor);
		} catch (Exception e) {
			logger.error("失败", e);
		}
		return"redirect:selallConfig_major";
	}
	
}
