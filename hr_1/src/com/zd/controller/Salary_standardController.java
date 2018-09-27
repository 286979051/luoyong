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
}
