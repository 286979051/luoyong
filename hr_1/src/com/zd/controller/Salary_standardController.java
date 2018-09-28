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
	
	//ȥ��ҳ��Controller
	@RequestMapping({"salaryCriterion/salarystandard_query_locate","salaryCriterion/salarystandard_change_locate"})
	public String topage(HttpServletRequest Request) {
		String path = Request.getServletPath();
		path = path.substring(1, path.length());
		return path;
	}
	
	//��ѯȥtosalarystandard_register������
	@RequestMapping("/tosalarystandard_register")
	public String tosalarystandard_register(Map<String, Object> map) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			//ʵ�ֲ�ѯ����
			List<Config_public_char> charlist = Config_public_charService.selsalary();
			//����ʱ���
			Long timeid = System.currentTimeMillis();
			//��ҳ����Ҫ������ͨ��map���͹�ȥ
			map.put("timeid", timeid);
			map.put("charlist", charlist);
		} catch (Exception e) {
			log.error("��תtosalarystandard_register.jspʧ��",e);
		}
		//���͵�salarystandard_register.jsp
		return "salaryCriterion/salarystandard_register";
	}
	
	//���һ��н���׼��Ϣ
	@RequestMapping("/addSalary_standard")
	public String addSalary_standard(Salary_standard salary_standard,@RequestParam Map xcxmMap) {
		Logger logger = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			StandardService.addstandard(salary_standard);String Standard_id = salary_standard.getStandard_id();
			Map moneyMap = new HashMap<>();
			// ��ȡmap�е����м� 1 money_1 2  money_2
			Set<String> keySet = xcxmMap.keySet();
			for (String key : keySet) {
				// ���������money_��ʼ�ľ���������Ҫ�ļ�
				if(key.startsWith("money_")) {
					// ��ȡid,�Լ����зָ�
					int  xcbzId = Integer.parseInt(key.split("_")[1]);
					// ��ȡ���
					double money = Double.parseDouble((String)xcxmMap.get(key));
					moneyMap.put("pbc_id", xcbzId);
					moneyMap.put("money", money);
					moneyMap.put("standard_id", Standard_id);
					// ���
					StandardService.addzm_some(moneyMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("���ʧ��",e);
		}
		return "salaryCriterion/salarystandard_register_success";
	}

	//��ѯȥsalarystandard_check_list������(��ҳ)
	@RequestMapping("/selallSalary")
	public String selallSalary(Map<String,Object> map) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0; //��ҳ��
			int start = 1; //��ǰҳ
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
			log.error("��ת��ҳʧ��",e);
		}
		return "salaryCriterion/salarystandard_check_list";
	}
	
	//βҳн���׼��Ϣ
	@RequestMapping("/tolast")
	public String tolast(Map<String, Object> map) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;//��ҳ��
			int start = 1;//��ǰҳ
			int count = //��ȡ����
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
			log.error("��תβҳʧ��",e);
		}
		return "salaryCriterion/salarystandard_check_list";
	}
	
	//��һҳн���׼��Ϣ
	@RequestMapping("/toup")
	public String toup(Map<String, Object> map,int start) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;//��ҳ��
			int count = //��ȡ����
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
			log.error("��ת��һҳʧ��",e);
		}
		return "salaryCriterion/salarystandard_check_list";
	}
	
	//��һҳн���׼��Ϣ
	@RequestMapping("/todown")
	public String todown(Map<String, Object> map,int start) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			int total = 0;//��ҳ��
			int count = //��ȡ����
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
			log.error("��ת��һҳʧ��",e);
		}
		return "salaryCriterion/salarystandard_check_list";
	}
	
	//ҳ����תн���׼��Ϣ
	@RequestMapping("/tojump")
	public String tojump(Map<String, Object> map,int pages) {
			Logger log = LoggerFactory.getLogger(Salary_standardController.class);
			try {
				int count = //��ȡ��Ϣ����
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
				log.error("ҳ����תʧ��",e);
			}
			return "salaryCriterion/salarystandard_check_list";
		}	
	
	//�����˲�ѯ������Ϣ
	@RequestMapping("/selone_Salary_standard")
	public String selone_Salary_standard(int ssd_id,Map<String, Object> map,String standard_id) {
		Logger log = LoggerFactory.getLogger(Salary_standardController.class);
		try {
			//��ѯ������Ϣ
			Salary_standard salary_standard = 
					StandardService.selone_Salary_standard(ssd_id);
			map.put("salary_standard", salary_standard);
			//�����˲�ѯ������Ϣ--��Ŀ��Ϣ
			List<zm_some> zm_somelist =  StandardService.selone_zmsome(standard_id);
			map.put("zm_somelist", zm_somelist);
		} catch (Exception e) {
			log.error("ҳ����תʧ��",e);
		}
		return "salaryCriterion/salarystandard_check";
	}
}
