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
		//�Ǽ���
		user user = (user) session.getAttribute("user");
		map.put("user", user);
		//����Ŀ����
		List<Config_public_char> arr = salary_grantService.selItem();
		map.put("arr", arr);
		//��һ��������������
		int FBCount = salary_grantService.queryFBCount(fname);
		map.put("FBCount", FBCount);
		//�鵵����ź�����
		List<Human_file> list1 = salary_grantService.queryFHuman(fname);
		for (Human_file human_file : list1) {
			// ����н���׼id��ѯн����Ŀ
			String ssid = human_file.getSalary_standard_id();
			//��ѯÿ���˵�н����Ŀ--list2
			List<Salary_standard_details> list2 = salary_grantService.queryssd(ssid);
			human_file.setSsdlist(list2);
			System.out.println(list2);
		}
		map.put("list1", list1);
		//����ʱ���
		Long times = System.currentTimeMillis();
		map.put("times", times);
		
		return "salaryGrant/register_commit";
	}
	
	//����
	@RequestMapping("querySHuman")
	public String querySHuman(Map map,String sname,HttpSession session) {
		//�Ǽ���
		user user = (user) session.getAttribute("user");
		map.put("user", user);
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
			List<Salary_standard_details> list2 = salary_grantService.queryssd(ssid);
			human_file.setSsdlist(list2);
			System.out.println(list2);
		}
		map.put("list1", list1);
		//����ʱ���
		Long times = System.currentTimeMillis();
		map.put("times", times);
			
		return "salaryGrant/register_commit";
	}
	
	//����
	@RequestMapping("queryTHuman")
	public String queryTHuman(Map map,String tname,HttpSession session) {
		//�Ǽ���
		user user = (user) session.getAttribute("user");
		map.put("user", user);
		//����Ŀ����
		List<Config_public_char> arr = salary_grantService.selItem();
		map.put("arr", arr);
		//��һ��������������
		int FBCount = salary_grantService.queryFBCount(tname);
		map.put("FBCount", FBCount);
		//�鵵����ź�����
		List<Human_file> list1 = salary_grantService.queryTHuman(tname);
		for (Human_file human_file : list1) {
			// ����н���׼id��ѯн����Ŀ
			String ssid = human_file.getSalary_standard_id();
			//��ѯÿ���˵�н����Ŀ--list2
			List<Salary_standard_details> list2 = salary_grantService.queryssd(ssid);
			human_file.setSsdlist(list2);
			System.out.println(list2);
		}
		map.put("list1", list1);
		//����ʱ���
		Long times = System.currentTimeMillis();
		map.put("times", times);
			
		return "salaryGrant/register_commit";
	}
	
	
}
