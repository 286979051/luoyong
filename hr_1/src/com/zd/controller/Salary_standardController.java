package com.zd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.Config_public_char;
import com.zd.entity.Salary_standard;
import com.zd.entity.zm_some;
import com.zd.service.IConfig_public_charservice;
import com.zd.service.IStandardService;

@Controller
public class Salary_standardController {

	@Autowired
	private IConfig_public_charservice Config_public_charService;
	@Autowired
	private IStandardService StandardService;
	
	//去网页的Controller
	@RequestMapping({"salaryCriterion/salarystandard_query_locate","salaryCriterion/salarystandard_change_locate"})
	public String topage(HttpServletRequest Request) {
		String path = Request.getServletPath();
		path = path.substring(1, path.length());
		return path;
	}
	
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
	
	//添加一个薪酬标准信息
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

	//查询去salarystandard_check_list的内容(首页)
	@RequestMapping("/selallSalary")
	public String selallSalary(Map<String,Object> map) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0; //总页数
			int start = 1; //当前页
			int count = StandardService.selallSalary_count();
			map.put("count", count);
			if(count%10==0) {
				total = count/10;
				map.put("total", total);
			}else {
				total = count/10+1;
				map.put("total", total);
			}
			map.put("start", start);
		List<Salary_standard> salary_standards = StandardService.selallSalary((start-1)*10);
		map.put("salary_standards", salary_standards);
		} catch (Exception e) {
			log.error("跳转首页失败",e);
		}
		return "salaryCriterion/salarystandard_check_list";
	}
	
	//尾页薪酬标准信息
	@RequestMapping("/tolast")
	public String tolast(Map<String, Object> map) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;//总页数
			int start = 1;//当前页
			int count = //获取总数
					StandardService.selallSalary_count();
			map.put("count", count);
			if(count%10==0) {
				total = count/10;
				map.put("total", total);
			}else {
				total = count/10+1;
				map.put("total", total);
			}
			map.put("start", total);
			List<Salary_standard> salary_standards = StandardService.selallSalary((total-1)*10);
			map.put("salary_standards", salary_standards);
		} catch (Exception e) {
			log.error("跳转尾页失败",e);
		}
		return "salaryCriterion/salarystandard_check_list";
	}
	
	//上一页薪酬标准信息
	@RequestMapping("/toup")
	public String toup(Map<String, Object> map,int start) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;//总页数
			int count = //获取总数
					StandardService.selallSalary_count();
			map.put("count", count);
			if(count%10==0) {
				total = count/10;
				map.put("total", total);
			}else {
				total = count/10+1;
				map.put("total", total);
			}
			map.put("start", start-1);
			List<Salary_standard> salary_standards = StandardService.selallSalary((start-2)*10);
			map.put("salary_standards", salary_standards);
		} catch (Exception e) {
			log.error("跳转上一页失败",e);
		}
		return "salaryCriterion/salarystandard_check_list";
	}
	
	//下一页薪酬标准信息
	@RequestMapping("/todown")
	public String todown(Map<String, Object> map,int start) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;//总页数
			int count = //获取总数
					StandardService.selallSalary_count();
			map.put("count", count);
			if(count%10==0) {
				total = count/10;
				map.put("total", total);
			}else {
				total = count/10+1;
				map.put("total", total);
			}
			map.put("start", start+1);
			List<Salary_standard> salary_standards = StandardService.selallSalary((start)*10);
			map.put("salary_standards", salary_standards);
		} catch (Exception e) {
			log.error("跳转下一页失败",e);
		}
		return "salaryCriterion/salarystandard_check_list";
	}
	
	//页面跳转薪酬标准信息
	@RequestMapping("/tojump")
	public String tojump(Map<String, Object> map,int pages) {
			Logger log = LoggerFactory.getLogger(Salary_standardController.class);
			try {
				int count = //获取信息总数
						StandardService.selallSalary_count();
				map.put("count", count);
				if(count%10==0) {
					int total = count/10;
					map.put("total", total);
				}else {
					int  total = count/10+1;
					map.put("total", total);
				}
				map.put("start", pages);
				List<Salary_standard> salary_standards = StandardService.selallSalary((pages-1)*10);
				map.put("salary_standards", salary_standards);
			} catch (Exception e) {
				log.error("页面跳转失败",e);
			}
			return "salaryCriterion/salarystandard_check_list";
		}	
	
	//进复核查询单条信息
	@RequestMapping("/selone_Salary_standard")
	public String selone_Salary_standard(int ssd_id,Map<String, Object> map,String standard_id) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			//查询基本信息
			Salary_standard salary_standard = 
					StandardService.selone_Salary_standard(ssd_id);
			map.put("salary_standard", salary_standard);
			//进复核查询单条信息--项目信息
			List<zm_some> zm_somelist =  StandardService.selone_zmsome(standard_id);
			map.put("zm_somelist", zm_somelist);
		} catch (Exception e) {
			log.error("页面跳转失败",e);
		}
		return "salaryCriterion/salarystandard_check";
	}
}
