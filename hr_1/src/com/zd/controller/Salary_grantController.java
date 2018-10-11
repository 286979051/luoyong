package com.zd.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Human_file;
import com.zd.entity.Salary_grant;
import com.zd.entity.Salary_grant_details;
import com.zd.entity.Salary_standard_details;
import com.zd.entity.user;
import com.zd.entity.zm_some;
import com.zd.service.ISalary_grantService;
import com.zd.service.IUserService;

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
			
			//��һ������������
			int human = salary_grantService.selFHuman();
			map.put("human", human);
			
			//�����н������(һ��)
			String firstsum = salary_grantService.selFMoney();
			map.put("firstsum", firstsum);
			
			//��ʵ���ܶ�(һ��)
			String firstShisum = salary_grantService.selFShiMoney();
			map.put("firstShisum", firstShisum);

			//��һ���������֣��ܽ�����
			List<Map> list = salary_grantService.selFirst();
			map.put("list", list);
			return "salaryGrant/register_list";
		}
		if(na==2) {
			//��н������
			int secondcount = salary_grantService.selSCount();
			map.put("secondcount", secondcount);
			
			//���������������
			int human = salary_grantService.selSHuman();
			map.put("human", human);
			
			//�����н������(����)
			String secondsum = salary_grantService.selSMoney();
			map.put("secondsum", secondsum);
			
			//��ʵ���ܶ�(����)
			String secondShisum = salary_grantService.selSShiMoney();
			map.put("secondShisum", secondShisum);
			
			//������������֣��ܽ�����
			List<Map> list = salary_grantService.selSecond();
			map.put("list", list);
			return "salaryGrant/register_list2";
		}
		if(na==3) {
			//��н������
			int thirdcount = salary_grantService.selTCount();
			map.put("thirdcount", thirdcount);
			
			//����������������
			int human = salary_grantService.selTHuman();
			map.put("human", human);
			
			//�����н������(����)
			String thirdsum = salary_grantService.selTMoney();
			map.put("thirdsum", thirdsum);
			
			//��ʵ���ܶ�(����)
			String thirdShisum = salary_grantService.selTShiMoney();
			map.put("thirdShisum", thirdShisum);
			
			//�������������֣��ܽ�����
			List<Map> list = salary_grantService.selThird();
			map.put("list", list);
			return "salaryGrant/register_list3";
		}
		return null;
	}
	
	
	//һ��
	@RequestMapping("queryFHuman")
	public String queryFHuman(Map map,String fname,HttpSession session) {
		double sum = 0;
		double su = 0;
		//�Ǽ���
		user user = (user) session.getAttribute("user");
		map.put("user", user);
		//��һ��������
		Config_file_first_kind cffk = salary_grantService.selF(fname);
		map.put("cffk",cffk );
		
		//����Ŀ����
		List<Config_public_char> arr = salary_grantService.selItem();
		map.put("arr", arr);
		//�����н������
		String selsum = salary_grantService.selsum(fname);
		map.put("selsum", selsum);
		//��һ��������������
		int FBCount = salary_grantService.queryFBCount(fname);
		map.put("FBCount", FBCount);
		//�鵵����ź�����
		List<Human_file> list1 = salary_grantService.queryFHuman(fname);
		for (Human_file human_file : list1) {
			// ����н���׼id��ѯн����Ŀ
			String ssid = human_file.getSalary_standard_id();
			//��ѯÿ���˵�н����Ŀ--list2
			sum=0;
			List<Salary_standard_details> list2 = salary_grantService.queryssd(ssid);
			for (Salary_standard_details Salary_standard_details : list2) {
				sum += Salary_standard_details.getSalary();
				su+=Salary_standard_details.getSalary();
			}
			human_file.setSalary_sum(sum);
			human_file.setSsdlist(list2);
		}
		map.put("su",su);
		map.put("list1", list1);
		//����ʱ���
		Long times = System.currentTimeMillis();
		map.put("times", times);
		return "salaryGrant/register_commit";
	}
	
	//����
	@RequestMapping("querySHuman")
	public String querySHuman(Map map,String sname,HttpSession session) {
		double sum = 0;
		double su = 0;
		//�Ǽ���
		user user = (user) session.getAttribute("user");
		map.put("user", user);
		//�����������
		Config_file_second_kind cffk = salary_grantService.selS(sname);
		map.put("cffk", cffk);
		//����Ŀ����
		List<Config_public_char> arr = salary_grantService.selItem();
		map.put("arr", arr);
		//��һ��������������
		int FBCount = salary_grantService.querySBCount(sname);
		map.put("FBCount", FBCount);
		//�鵵����ź�����
		List<Human_file> list1 = salary_grantService.querySHuman(sname);
		for (Human_file human_file : list1) {
			// ����н���׼id��ѯн����Ŀ
			String ssid = human_file.getSalary_standard_id();
			//��ѯÿ���˵�н����Ŀ--list2
			sum=0;
			List<Salary_standard_details> list2 = salary_grantService.queryssd(ssid);
			for (Salary_standard_details Salary_standard_details : list2) {
				sum += Salary_standard_details.getSalary();
				su+=Salary_standard_details.getSalary();
			}
			human_file.setSalary_sum(sum);
			human_file.setSsdlist(list2);
		}
		map.put("su",su);
		map.put("list1", list1);
		//����ʱ���
		Long times = System.currentTimeMillis();
		map.put("times", times);
		return "salaryGrant/register_commit2";
	}
	
	//����
	@RequestMapping("queryTHuman")
	public String queryTHuman(Map map,String tname,HttpSession session) {
		double sum = 0;
		double su = 0;
		//�Ǽ���
		user user = (user) session.getAttribute("user");
		map.put("user", user);
		//������������
		Config_file_third_kind cffk = salary_grantService.selT(tname);
		map.put("cffk", cffk);
		//����Ŀ����
		List<Config_public_char> arr = salary_grantService.selItem();
		map.put("arr", arr);
		//��һ��������������
		int FBCount = salary_grantService.queryTBCount(tname);
		map.put("FBCount", FBCount);
		//�鵵����ź�����
		List<Human_file> list1 = salary_grantService.queryTHuman(tname);
		for (Human_file human_file : list1) {
			// ����н���׼id��ѯн����Ŀ
			String ssid = human_file.getSalary_standard_id();
			//��ѯÿ���˵�н����Ŀ--list2
			sum=0;
			List<Salary_standard_details> list2 = salary_grantService.queryssd(ssid);
			for (Salary_standard_details Salary_standard_details : list2) {
				sum += Salary_standard_details.getSalary();
				su+=Salary_standard_details.getSalary();
			}
			human_file.setSalary_sum(sum);
			human_file.setSsdlist(list2);
		}
		map.put("su",su);
		map.put("list1", list1);
		//����ʱ���
		Long times = System.currentTimeMillis();
		map.put("times", times);
		return "salaryGrant/register_commit3";
	}
	
	//�Ǽ�
	@RequestMapping("regist")
	public String regist(@RequestParam double salaryStandardSum, @RequestParam double salaryPaidSum, Salary_grant sgt, @RequestParam List<String> salary_standard_id, @RequestParam List<String> salary_grant_id, @RequestParam List<String> human_id,@RequestParam List<String> human_name,@RequestParam List<Double> bouns_sum, @RequestParam List<Double> sale_sum, @RequestParam List<Double> deduct_sum,@RequestParam List<Double> salary_standard_sum, @RequestParam List<Double> salary_paid_sum ) {
		Salary_grant_details sgd = new Salary_grant_details();
		for(int index = 0 ; index<human_name.size() ; index++) {
			sgd.setSalary_grant_id(salary_grant_id.get(0));
			sgd.setHuman_id(human_id.get(index));
			sgd.setHuman_name(human_name.get(index));
			sgd.setBouns_sum(bouns_sum.get(index));
			sgd.setSale_sum(sale_sum.get(index));
			sgd.setDeduct_sum(deduct_sum.get(index));
			sgd.setSalary_standard_sum(salary_standard_sum.get(index));
			sgd.setSalary_paid_sum(salary_paid_sum.get(index));
			salary_grantService.addDetails(sgd);
			
			sgt.setSalary_grant_id(salary_grant_id.get(0));
			sgt.setSalary_standard_id(salary_standard_id.get(index));
			sgt.setSalary_standard_sum(salaryStandardSum);
			sgt.setSalary_paid_sum(salaryPaidSum);
		}
		
		salary_grantService.addgrant(sgt);
		
		return "salaryGrant/register_success";
	}
	
	
	@RequestMapping("selAll")
	public String selAll(Map map) {
		List<Salary_grant> sgList = salary_grantService.selAll();
		map.put("sgList", sgList);
		return "salaryGrant/check_list";
	}
	
	
	
	
	
	
	
	
	
}
