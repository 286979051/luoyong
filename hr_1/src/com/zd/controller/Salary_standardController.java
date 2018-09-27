package com.zd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;
import com.zd.service.IConfig_public_charservice;
import com.zd.service.IStandardService;

@Controller
public class Salary_standardController {

	@Autowired
	private IConfig_public_charservice Config_public_charService;
	@Autowired
	private IStandardService StandardService;
	
	//查询去tosalarystandard_register的内容
	@RequestMapping("/tosalarystandard_register")
	public String tosalarystandard_register(Map<String, Object> map) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			//实现查询功能
			List<Config_public_char> charlist = Config_public_charService.selsalary();
			//生成时间戳
			Long timeid = System.currentTimeMillis();
			//将页面需要的数据通过map发送过去
			map.put("timeid", timeid);
			map.put("charlist", charlist);
		} catch (Exception e) {
			log.error("跳转tosalarystandard_register.jsp失败",e);
		}
		//发送到salarystandard_register.jsp
		return "salaryCriterion/salarystandard_register";
	}
	
	@RequestMapping("/addSalary_standard")
	public String addSalary_standard(Salary_standard salary_standard,@RequestParam Map xcxmMap) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			StandardService.addstandard(salary_standard);String Standard_id = salary_standard.getStandard_id();
			Map moneyMap = new HashMap<>();
			// 获取map中的所有键 1 money_1 2  money_2
			Set<String> keySet = xcxmMap.keySet();
			for (String key : keySet) {
				// 如果键是以money_开始的就是我们需要的键
				if(key.startsWith("money_")) {
					// 获取id,对键进行分割
					int  xcbzId = Integer.parseInt(key.split("_")[1]);
					// 获取金额
					double money = Double.parseDouble((String)xcxmMap.get(key));
					moneyMap.put("pbc_id", xcbzId);
					moneyMap.put("money", money);
					moneyMap.put("standard_id", Standard_id);
					// 添加
					StandardService.addzm_some(moneyMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("添加失败",e);
		}
		return "salaryCriterion/salarystandard_register_success";
	}
}
