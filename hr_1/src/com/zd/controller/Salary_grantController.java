package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Human_file;
import com.zd.entity.Salary_grant;
import com.zd.service.ISalary_grantService;

@Controller
public class Salary_grantController {

	@Autowired
	private ISalary_grantService salary_grantService;
	
	
	//去register_loctae.jsp
	@RequestMapping("toloctae")
	public String toloctae() {
		return "salaryGrant/register_locate";
	}
	
	@RequestMapping("sel")
	public String sel(Map map,int na) {
		if(na==1) {
			//查薪酬总数
			int firstcount = salary_grantService.selFCount();
			map.put("firstcount", firstcount);
			
			//查总人数
			int human = salary_grantService.selHuman();
			map.put("human", human);
			
			//查基本薪酬总数(一级)
			double firstsum = salary_grantService.selFMoney();
			map.put("firstsum", firstsum);
			
			//查实发总额(一级)
			double firstShisum = salary_grantService.selFShiMoney();
			map.put("firstShisum", firstShisum);
			
			//查一级机构名字，总金额，人数
			List<Map> list = (List<Map>) salary_grantService.selFist();
			map.put("list", list);
			return "salaryGrant/register_list";
		}
		if(na==2) {
			//查薪酬总数
			int secondcount = salary_grantService.selSCount();
			map.put("secondcount", secondcount);
			
			//查总人数
			int human = salary_grantService.selHuman();
			map.put("human", human);
			
			//查基本薪酬总数(二级)
			double secondsum = salary_grantService.selSMoney();
			map.put("secondsum", secondsum);
			
			//查实发总额(二级)
			double secondShisum = salary_grantService.selSShiMoney();
			map.put("secondShisum", secondShisum);
			
			//查二级机构名字，总金额，人数
			List<Map> list = (List<Map>) salary_grantService.selSecond();
			map.put("list", list);
			return "salaryGrant/register_list2";
		}
		if(na==3) {
			//查薪酬总数
			int thirdcount = salary_grantService.selTCount();
			map.put("thirdcount", thirdcount);
			
			//查总人数
			int human = salary_grantService.selHuman();
			map.put("human", human);
			
			//查基本薪酬总数(三级)
			double thirdsum = salary_grantService.selTMoney();
			map.put("thirdsum", thirdsum);
			
			//查实发总额(三级)
			double thirdShisum = salary_grantService.selTShiMoney();
			map.put("thirdShisum", thirdShisum);
			
			//查三级机构名字，总金额，人数
			List<Map> list = (List<Map>) salary_grantService.selThird();
			map.put("list", list);
			return "salaryGrant/register_list3";
		}
		return null;
	}
	
	
	//去register_commit.jsp
	@RequestMapping("tocommit")
	public String tocommit() {
		return "salaryGrant/register_commit";
	}
	
	
}
