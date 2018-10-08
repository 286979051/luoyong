package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;
@Controller
public class Config_majorController {
	//��־����
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IConfig_majorService config_majorService;
	
	//ע��ְλ�����service,�������֮ǰ�Ĳ�ѯ
	@Autowired
	private IConfig_major_kindService majorkindService;
		
	
	@RequestMapping("ErMajorQuery")
	@ResponseBody
	public List<Config_major> ErMajorQuery(String id){
		List<Config_major> majorlist = config_majorService.ErMajorQuery(id);
		return majorlist;
	}
	
	//��ѯ����ְλ
	@RequestMapping("selallConfig_major")
	public String selallConfig_major(Map map) {
		try {
			List<Config_major> Config_majorlist = config_majorService.selallConfig_major();
			map.put("Config_majorlist", Config_majorlist);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return"/client/major";
	}
	
	//ɾ��ְλ
	@RequestMapping("deletemajor")
	@ResponseBody
	public String deletemajor(int makid) {
		try {
			config_majorService.deletemajor(makid);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return"1";
	}
	
	//���ְλ֮ǰ��ѯ����ְλ����
	@RequestMapping("addmajorkindlist")
	public String majorkindlist (Map map) {
			try {
				List<Config_major_kind> majorkind = majorkindService.majorkindlist();
				map.put("majorkind", majorkind);
				long systime = System.currentTimeMillis();
				map.put("systime", systime);
			} catch (Exception e) {
				logger.error("ʧ��", e);
			}
			return"/client/major_add";
		}
	
	//���ְλ
	@RequestMapping("addConfig_major")
	public String addConfig_major(Config_major Configmajor,String majorkindid) {
		try {
			//����ְλ����id��ѯְλ�������Ʋ������Ƹ��������������
			Config_major_kind kindname = config_majorService.majorkindname(majorkindid);
			Configmajor.setMajorkindname(kindname.getMajor_kind_name());
			//������ӷ���ִ�����
			config_majorService.addConfig_major(Configmajor);
		} catch (Exception e) {
			logger.error("ʧ��", e);
		}
		return"redirect:selallConfig_major";
	}
	
}
