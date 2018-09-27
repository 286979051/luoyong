package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zd.entity.Engage_major_release;
import com.zd.service.IEngage_major_releaseService;
@Controller
public class Engage_major_releaseController {

	@Autowired
	private IEngage_major_releaseService engage_major_releaseService;
	
	//ְλ����ǼǱ��ѯ
	@RequestMapping("releaseQuery")
	public String releaseQuery(Map map) {
		List<Engage_major_release> releaseList = engage_major_releaseService.releaseQuery();
		map.put("releaseList", releaseList);
		return "/recruit/position/position_change_update";
	}
	
	//ְλ����ǼǱ��ѯ����
	@RequestMapping("releaseQueryById")
	public String releaseQueryById(int id , Map map) {
		Engage_major_release release = engage_major_releaseService.releaseQueryById(id);
		map.put("release", release);
		return "/recruit/position/position_release_change";
	}
	
	//ְλ����ǼǱ��޸�
	@RequestMapping("releaseUpd")
	public String releaseUpd(Engage_major_release Engage_major_release) {
		engage_major_releaseService.releaseUpd(Engage_major_release);
		return "redirect:releaseQuery";
	}
	
	//ְλ����Ǽ�ɾ��
	@RequestMapping("releaseDelete")
	@ResponseBody
	public String releaseDelete(int mid) {
		engage_major_releaseService.releaseDelete(mid);
		return "1";
	}
	
}
