package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Engage_major_release;
import com.zd.service.IConfig_file_first_kindService;
import com.zd.service.IConfig_file_second_kindService;
import com.zd.service.IConfig_file_third_kindService;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IConfig_public_charservice;
import com.zd.service.IEngage_major_releaseService;
@Controller
public class Engage_major_releaseController {
	@Autowired
	private IConfig_file_first_kindService config_file_first_kindService;
	@Autowired
	private IConfig_file_second_kindService config_file_second_kindService;
	@Autowired
	private IConfig_file_third_kindService config_file_third_kindService;
	@Autowired
	private IConfig_major_kindService config_major_kindService;
	@Autowired
	private IConfig_majorService config_majorService;
	@Autowired
	private IConfig_public_charservice config_public_charservice;
	@Autowired
	private IEngage_major_releaseService engage_major_releaseService;
	
	//ְλ����ǼǱ������޸�
	@RequestMapping("releaseUpdShenQ")
	private String releaseUpdShenQ(Engage_major_release engage_major_release) {
		//һ����������������ѯ��ֵ
		Config_file_first_kind cffk = config_file_first_kindService.queryDan(engage_major_release.getFirst_kind_id());
		engage_major_release.setFirst_kind_name(cffk.getFirstkindname());
		//������������������ѯ��ֵ
		Config_file_second_kind cfsk =  config_file_second_kindService.queryDan(engage_major_release.getSecond_kind_id());
		engage_major_release.setSecond_kind_name(cfsk.getSecondkindname());
		//������������������ѯ��ֵ
		Config_file_third_kind cftk = config_file_third_kindService.queryDan(engage_major_release.getThird_kind_id());
		engage_major_release.setThird_kind_name(cftk.getThirdkindname());
		//ְҵ����һ���������鸳ֵ
		Config_major_kind cmk =  config_major_kindService.majorQueryDan(engage_major_release.getMajor_kind_id());
		engage_major_release.setMajor_kind_name(cmk.getMajor_kind_name());
		//ְҵ��������������鸳ֵ
		Config_major cmajor = config_majorService.ErMajorQueryDan(engage_major_release.getMajor_id());
		engage_major_release.setMajor_name(cmajor.getMajorname());
		
		engage_major_releaseService.releaseUpdShenQ(engage_major_release);
		
		return "redirect:releaseQuery1";
	}
	
	//ְλ����ǼǱ��ѯ���뵥��
	@RequestMapping("releaseQueryByIdSQ")
	public String releaseQueryByIdSQ(int id,Map map) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			Engage_major_release release = engage_major_releaseService.releaseQueryById(id);
			List<Config_public_char> cpcList = config_public_charservice.QueryEngageType();
			List<Config_file_first_kind> cffk = config_file_first_kindService.query();
			List<Config_major_kind> major = config_major_kindService.majorQuery();
			List<Config_public_char> publicList = config_public_charservice.QueryEngageType();
					
			List<Config_file_second_kind> cfskL = config_file_second_kindService.queryById(release.getFirst_kind_id());
			List<Config_file_third_kind> cftkL = config_file_third_kindService.queryById(release.getSecond_kind_id());
			List<Config_major> cmL = config_majorService.ErMajorQuery(release.getMajor_kind_id());
			map.put("cmL", cmL);
			map.put("cftkL", cftkL);
			map.put("cfskL", cfskL);
			map.put("release", release);
			map.put("cpcList", cpcList);
			map.put("cffk", cffk);
			map.put("major", major);
			map.put("publicList", publicList);
		} catch (Exception e) {
			logger.error("ְλ����ǼǱ��ѯ����", e);
		}
		return "/recruit/position/position_release_details";
	}
		
	//ְλ����ǼǱ��ѯ
	@RequestMapping("releaseQuery")
	public String releaseQuery(Map map) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			List<Engage_major_release> releaseList = engage_major_releaseService.releaseQuery();
			map.put("releaseList", releaseList);
		} catch (Exception e) {
			logger.error("ְλ����ǼǱ��ѯ", e);
		}
		return "/recruit/position/position_change_update";
	}
	
	//ְλ����ǼǱ��ѯ
		@RequestMapping("releaseQuery1")
		public String releaseQuery1(Map map) {
			Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
			try {
				List<Engage_major_release> releaseList = engage_major_releaseService.releaseQuery();
				map.put("releaseList", releaseList);
			} catch (Exception e) {
				logger.error("ְλ����ǼǱ��ѯ", e);
			}
			return "/recruit/position/position_release_search";
		}
	//ְλ����ǼǱ��ѯ����
	@RequestMapping("releaseQueryById")
	public String releaseQueryById(int id , Map map) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			Engage_major_release release = engage_major_releaseService.releaseQueryById(id);
			List<Config_public_char> cpcList = config_public_charservice.QueryEngageType();
			map.put("release", release);
			map.put("cpcList", cpcList);
		} catch (Exception e) {
			logger.error("ְλ����ǼǱ��ѯ����", e);
		}
		return "/recruit/position/position_release_change";
	}
	
	//ְλ����ǼǱ��޸�
	@RequestMapping("releaseUpd")
	public String releaseUpd(Engage_major_release engage_major_release) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			Config_public_char cpc = config_public_charservice.QueryEngageTypeDan(engage_major_release.getMre_id());
			engage_major_release.setEngage_type(cpc.getAttribute_name());
			engage_major_releaseService.releaseUpd(engage_major_release);
		} catch (Exception e) {
			logger.error("ְλ����ǼǱ��޸�", e);
		}
		return "redirect:releaseQuery";
	}
	
	//ְλ����Ǽ�ɾ��
	@RequestMapping("releaseDelete")
	@ResponseBody
	public String releaseDelete(int mid) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			engage_major_releaseService.releaseDelete(mid);
		} catch (Exception e) {
			logger.error("ְλ����Ǽ�ɾ��", e);
		}
		return "1";
	}
	//ְλ����Ǽ����
	@RequestMapping("releaseInsetr")
	public String releaseInsetr(Engage_major_release Engage_major_release, int pbc_id) {
		Logger logger = LoggerFactory.getLogger(Engage_major_releaseController.class);
		try {
			//һ����������������ѯ��ֵ
			Config_file_first_kind cffk = config_file_first_kindService.queryDan(Engage_major_release.getFirst_kind_id());
			Engage_major_release.setFirst_kind_name(cffk.getFirstkindname());
			//ְҵ����һ���������鸳ֵ
			Config_major_kind cmk =  config_major_kindService.majorQueryDan(Engage_major_release.getMajor_kind_id());
			Engage_major_release.setMajor_kind_name(cmk.getMajor_kind_name());
			//ְҵ��������������鸳ֵ
			Config_major cmajor = config_majorService.ErMajorQueryDan(Engage_major_release.getMajor_id());
			Engage_major_release.setMajor_name(cmajor.getMajorname());
			//��ѯ��Ƹ���͵��鸳ֵ
			Config_public_char cpc = config_public_charservice.QueryEngageTypeDan(pbc_id);
			Engage_major_release.setEngage_type(cpc.getAttribute_name());
			if(Engage_major_release.getSecond_kind_id()==null || Engage_major_release.getSecond_kind_id()=="" ) {
				engage_major_releaseService.releaseInsert3(Engage_major_release);
				return "redirect:releaseQuery";
			}
			if(Engage_major_release.getThird_kind_id()==null || Engage_major_release.getThird_kind_id()=="") {
				//������������������ѯ��ֵ
				Config_file_second_kind cfsk =  config_file_second_kindService.queryDan(Engage_major_release.getThird_kind_id());
				Engage_major_release.setSecond_kind_name(cfsk.getSecondkindname());
				engage_major_releaseService.releaseInsert2(Engage_major_release);
			}
			if(Engage_major_release.getFirst_kind_id()!=null || Engage_major_release.getFirst_kind_id()!="") {
				//������������������ѯ��ֵ
				Config_file_second_kind cfsk =  config_file_second_kindService.queryDan(Engage_major_release.getSecond_kind_id());
				Engage_major_release.setSecond_kind_name(cfsk.getSecondkindname());
				//������������������ѯ��ֵ
				Config_file_third_kind cftk = config_file_third_kindService.queryDan(Engage_major_release.getThird_kind_id());
				Engage_major_release.setThird_kind_name(cftk.getThirdkindname());
				engage_major_releaseService.releaseInsert1(Engage_major_release);
			}
		} catch (Exception e) {
			logger.error("ְλ����Ǽ����", e);
		}
		return "redirect:releaseQuery";
	}
	
	
}
