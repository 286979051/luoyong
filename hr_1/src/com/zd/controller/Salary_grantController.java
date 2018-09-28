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
	
	
	//ȥregister_loctae.jsp
	@RequestMapping("toloctae")
	public String toloctae() {
		return "salaryGrant/register_locate";
	}
	
	@RequestMapping("sel")
	public String sel(Map map,int na) {
		if(na==1) {
			//��н������
			int firstcount = salary_grantService.selFCount();
			map.put("firstcount", firstcount);
			
			//��������
			int human = salary_grantService.selHuman();
			map.put("human", human);
			
			//�����н������(һ��)
			String firstsum = salary_grantService.selFMoney();
			map.put("firstsum", firstsum);
			
			//��ʵ���ܶ�(һ��)
			String firstShisum = salary_grantService.selFShiMoney();
			map.put("firstShisum", firstShisum);
			
			//��һ���������֣��ܽ�����
			List<Map> list = (List<Map>) salary_grantService.selFist();
			map.put("list", list);
			return "salaryGrant/register_list";
		}
		if(na==2) {
			//��н������
			int secondcount = salary_grantService.selSCount();
			map.put("secondcount", secondcount);
			
			//��������
			int human = salary_grantService.selHuman();
			map.put("human", human);
			
			//�����н������(����)
			String secondsum = salary_grantService.selSMoney();
			map.put("secondsum", secondsum);
			
			//��ʵ���ܶ�(����)
			String secondShisum = salary_grantService.selSShiMoney();
			map.put("secondShisum", secondShisum);
			
			//������������֣��ܽ�����
			List<Map> list = (List<Map>) salary_grantService.selSecond();
			map.put("list", list);
			return "salaryGrant/register_list2";
		}
		if(na==3) {
			//��н������
			int thirdcount = salary_grantService.selTCount();
			map.put("thirdcount", thirdcount);
			
			//��������
			int human = salary_grantService.selHuman();
			map.put("human", human);
			
			//�����н������(����)
			String thirdsum = salary_grantService.selTMoney();
			map.put("thirdsum", thirdsum);
			
			//��ʵ���ܶ�(����)
			String thirdShisum = salary_grantService.selTShiMoney();
			map.put("thirdShisum", thirdShisum);
			
			//�������������֣��ܽ�����
			List<Map> list = (List<Map>) salary_grantService.selThird();
			map.put("list", list);
			return "salaryGrant/register_list3";
		}
		return null;
	}
	
	
	//ȥregister_commit.jsp
	@RequestMapping("tocommit")
	public String tocommit() {
		return "salaryGrant/register_commit";
	}
	
	
}
