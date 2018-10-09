package com.zd.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zd.entity.Config_public_char;
import com.zd.entity.Human_file;
import com.zd.entity.Salary_standard_details;
import com.zd.entity.user;
import com.zd.entity.zm_some;
import com.zd.service.ISalary_grantService;
import com.zd.service.IUserService;

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
			
			//查一级机构总人数
			int human = salary_grantService.selFHuman();
			map.put("human", human);
			
			//查基本薪酬总数(一级)
			String firstsum = salary_grantService.selFMoney();
			map.put("firstsum", firstsum);
			
			//查实发总额(一级)
			String firstShisum = salary_grantService.selFShiMoney();
			map.put("firstShisum", firstShisum);

			//查一级机构名字，总金额，人数
			List<Map> list = salary_grantService.selFirst();
			map.put("list", list);
			return "salaryGrant/register_list";
		}
		if(na==2) {
			//查薪酬总数
			int secondcount = salary_grantService.selSCount();
			map.put("secondcount", secondcount);
			
			//查二级机构总人数
			int human = salary_grantService.selSHuman();
			map.put("human", human);
			
			//查基本薪酬总数(二级)
			String secondsum = salary_grantService.selSMoney();
			map.put("secondsum", secondsum);
			
			//查实发总额(二级)
			String secondShisum = salary_grantService.selSShiMoney();
			map.put("secondShisum", secondShisum);
			
			//查二级机构名字，总金额，人数
			List<Map> list = salary_grantService.selSecond();
			map.put("list", list);
			return "salaryGrant/register_list2";
		}
		if(na==3) {
			//查薪酬总数
			int thirdcount = salary_grantService.selTCount();
			map.put("thirdcount", thirdcount);
			
			//查三级机构总人数
			int human = salary_grantService.selTHuman();
			map.put("human", human);
			
			//查基本薪酬总数(三级)
			String thirdsum = salary_grantService.selTMoney();
			map.put("thirdsum", thirdsum);
			
			//查实发总额(三级)
			String thirdShisum = salary_grantService.selTShiMoney();
			map.put("thirdShisum", thirdShisum);
			
			//查三级机构名字，总金额，人数
			List<Map> list = salary_grantService.selThird();
			map.put("list", list);
			return "salaryGrant/register_list3";
		}
		return null;
	}
	
	
	//一级
	@RequestMapping("queryFHuman")
	public String queryFHuman(Map map,String fname,HttpSession session) {
		//登记人
		user user = (user) session.getAttribute("user");
		map.put("user", user);
		//查项目名称
		List<Config_public_char> arr = salary_grantService.selItem();
		map.put("arr", arr);
		//查一级本机构总人数
		int FBCount = salary_grantService.queryFBCount(fname);
		map.put("FBCount", FBCount);
		//查档案编号和名字
		List<Human_file> list1 = salary_grantService.queryFHuman(fname);
		for (Human_file human_file : list1) {
			// 根据薪酬标准id查询薪酬项目
			String ssid = human_file.getSalary_standard_id();
			//查询每个人的薪酬项目--list2
			List<Salary_standard_details> list2 = salary_grantService.queryssd(ssid);
			human_file.setSsdlist(list2);
			System.out.println(list2);
		}
		map.put("list1", list1);
		//生成时间戳
		Long times = System.currentTimeMillis();
		map.put("times", times);
		
		return "salaryGrant/register_commit";
	}
	
	//二级
	@RequestMapping("querySHuman")
	public String querySHuman(Map map,String sname,HttpSession session) {
		//登记人
		user user = (user) session.getAttribute("user");
		map.put("user", user);
		//查项目名称
		List<Config_public_char> arr = salary_grantService.selItem();
		map.put("arr", arr);
		//查一级本机构总人数
		int FBCount = salary_grantService.querySBCount(sname);
		map.put("FBCount", FBCount);
		//查档案编号和名字
		List<Human_file> list1 = salary_grantService.querySHuman(sname);
		for (Human_file human_file : list1) {
			// 根据薪酬标准id查询薪酬项目
			String ssid = human_file.getSalary_standard_id();
			//查询每个人的薪酬项目--list2
			List<Salary_standard_details> list2 = salary_grantService.queryssd(ssid);
			human_file.setSsdlist(list2);
			System.out.println(list2);
		}
		map.put("list1", list1);
		//生成时间戳
		Long times = System.currentTimeMillis();
		map.put("times", times);
			
		return "salaryGrant/register_commit";
	}
	
	//三级
	@RequestMapping("queryTHuman")
	public String queryTHuman(Map map,String tname,HttpSession session) {
		//登记人
		user user = (user) session.getAttribute("user");
		map.put("user", user);
		//查项目名称
		List<Config_public_char> arr = salary_grantService.selItem();
		map.put("arr", arr);
		//查一级本机构总人数
		int FBCount = salary_grantService.queryFBCount(tname);
		map.put("FBCount", FBCount);
		//查档案编号和名字
		List<Human_file> list1 = salary_grantService.queryTHuman(tname);
		for (Human_file human_file : list1) {
			// 根据薪酬标准id查询薪酬项目
			String ssid = human_file.getSalary_standard_id();
			//查询每个人的薪酬项目--list2
			List<Salary_standard_details> list2 = salary_grantService.queryssd(ssid);
			human_file.setSsdlist(list2);
			System.out.println(list2);
		}
		map.put("list1", list1);
		//生成时间戳
		Long times = System.currentTimeMillis();
		map.put("times", times);
			
		return "salaryGrant/register_commit";
	}
	
	
}
