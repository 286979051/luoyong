package com.zd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Human_file;
import com.zd.entity.Salary_standard_details;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IConfig_file_third_kindService;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IConfig_public_charservice;
import com.zd.service.IHuman_fileservice;
import com.zd.service.IStandardService;
/**
 * ��Ա�����ǼǵĿ���
 * @author Administrator
 *
 */

@Controller
public class Human_registerController {
	//һ����ѯ
	@Autowired
	private IConfig_file_first_kindService Config_file_first_kind;
	//����������ѯ
	@Autowired
	private IConfig_file_second_kindService config_file_second_kindService;
	//����������ѯ
	@Autowired
	private IConfig_file_third_kindService config_file_third_kindService;
	//��ѯ���еĹ����ֶ�
	@Autowired
	private IConfig_public_charservice Config_public_charservice;
	//��ѯ����
	@Autowired
	private IConfig_major_kindService Config_major_kindService;
	//ְҵ�Ķ�������
	@Autowired
	private IConfig_majorService Config_majorService;
	//н��
	@Autowired
	private IStandardService standardService;
	//��Ա���service
	@Autowired
	private IHuman_fileservice Human_fileservice;
	//��Ա������
	@Autowired
	private com.zd.service.IHuman_fileservice IHuman_fileservice;
	
	Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
	// ��ת��Ա�����Ǽ�
	@RequestMapping("/human_register")
	public String toPagehr(Map map){
		try {
			//һ����λ��ѯ
			List<com.zd.entity.Config_file_first_kind> query = Config_file_first_kind.query();
			List<Config_public_char> queryall = Config_public_charservice.queryall();
			List<Config_major_kind> majorQuery = Config_major_kindService.majorQuery();
			List<Salary_standard_details> selallSalary = standardService.selSalaryall();
			long currentTimeMillis = System.currentTimeMillis();
			map.put("currentTimeMillis", currentTimeMillis);
			map.put("arr3", selallSalary);
			map.put("arr2", majorQuery);
			map.put("arr1", queryall);
			map.put("arr", query);
		} catch (Exception e) {
			logger.error("һ����λ��ѯ", e);
		}
	return "humanResources/human_register";
	}	
	//����������ѯ
	@RequestMapping("/querySecondByFirstId")
	@ResponseBody
	public List<Config_file_second_kind> querySecondByFirstId(String id){
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		List<Config_file_second_kind> secondList = config_file_second_kindService.queryById(id);
		return secondList;
	}
	//����������ѯ
	@RequestMapping("/querythirdBySecondId")
	@ResponseBody
	public List<Config_file_third_kind> querythirdBySecondId(String id){
		List<Config_file_third_kind> thirdList =  config_file_third_kindService.queryById(id);
		return thirdList;
	}
	//ְҵ�Ķ�������
	@RequestMapping("/querymajorKindById")
	@ResponseBody
	public List<Config_major> querymajorKindById(int id){
		 List<Config_major> erMajorQuery = Config_majorService.ErMajorQuery(id);
		return erMajorQuery;
	}
	//��ת�ϴ�ҳ��
	@RequestMapping("/register_choose")
	public String register_choose(Human_file human_file,Map map) {
		try {
			Salary_standard_details selSalaryone = standardService.selSalaryone(human_file.getSalary_standard_name());
			String standard_id = selSalaryone.getStandard_id();
			String standard_name = selSalaryone.getStandard_name();
			human_file.setSalary_standard_name(standard_name);
			human_file.setSalary_standard_id(standard_id);
		Human_fileservice.human_chack_update(human_file);
		map.put("human_id", human_file.getHuman_id());
		} catch (Exception e) {
			logger.error("��ת�ϴ�ҳ��", e);
		}
		return "humanResources/register_choose_picture";
	}
	//��ת��ѯҳ��
	@RequestMapping("/query_locate")
	public String query_locate(Map map) {
		try {
		List<com.zd.entity.Config_file_first_kind> query = Config_file_first_kind.query();
		List<Config_major_kind> majorQuery = Config_major_kindService.majorQuery();
		map.put("arr", query);
		map.put("arr1", majorQuery);
		} catch (Exception e) {
			logger.error("��ת��ѯҳ��", e);
		}
		return "humanResources/query_locate";
	}
	//������ѯ
	@RequestMapping("/query_list")
	public String query_list(@RequestParam Map map,Map reqestmap) {
		try {
		String startDate = (String) map.get("utilBean.startDate");
		String endDate = (String) map.get("utilBean.endDate");
		
		SimpleDateFormat aDate=new SimpleDateFormat("yyyy-mm-dd");
		Date startDate1 = aDate.parse(startDate);
		Date endDate1 = aDate.parse(endDate);
		map.put("startDate", startDate1);
		map.put("endDate", endDate1);
		List<Human_file> query_list = Human_fileservice.query_list(map);
		reqestmap.put("arr", query_list);
		} catch (Exception e) {
			logger.error("������ѯ", e);
		}
		return "humanResources/query_list";
	}
	@RequestMapping("/query_list_information")
	public String query_list_information(Map map,String human_id) {
		Human_file humanfileidselall = Human_fileservice.Humanfileidselall(human_id);
		map.put("arr", humanfileidselall);
		return "humanResources/query_list_information";
	}
	//ɾ������Ϣ��ʾ
	@RequestMapping("/delete_list_information")
	public String delete_list_information(Map map,String human_id) {
		Human_file humanfileidselall = Human_fileservice.Humanfileidselall(human_id);
		map.put("arr", humanfileidselall);
		return "humanResources/delete_list_information";
	}
	
	@RequestMapping("/change_list_information")
	public String change_list_information(Map map,String human_id) {
		List<Human_file> human_fileselall = IHuman_fileservice.Humanfileallsel();
		List<Config_public_char> queryall = Config_public_charservice.queryall();
		List<Salary_standard_details> selallSalary = standardService.selSalaryall();
		map.put("arr2", selallSalary);
		map.put("arr1", queryall);
		map.put("human_id", human_id);
		map.put("arr", human_fileselall);
		return "humanResources/change_list_information";
	}
	
	//��ת���ҳ��
	@RequestMapping("/registerchoose")
	public String registerchoose(Human_file human_file,Map map) {
		try {
			Salary_standard_details selSalaryone = standardService.selSalaryone(human_file.getSalary_standard_name());
			String standard_id = selSalaryone.getStandard_id();
			String standard_name = selSalaryone.getStandard_name();
			human_file.setSalary_standard_name(standard_name);
			human_file.setSalary_standard_id(standard_id);
			Human_fileservice.human_chack_upd(human_file);
			map.put("human_id", human_file.getHuman_id());
			} catch (Exception e) {
				logger.error("��ת�ϴ�ҳ��", e);
			}
			return "humanResources/register_choose_picture";
		}
}
