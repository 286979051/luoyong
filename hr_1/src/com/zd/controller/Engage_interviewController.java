package com.zd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.Config_major_kind;
import com.zd.entity.Engage_interview;
import com.zd.entity.Engage_resume;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IEngage_interviewService;
import com.zd.service.IEngage_resumeService;
import com.zd.service.impl.Config_major_kindService;

@Controller
public class Engage_interviewController {

	@Autowired
	private IEngage_interviewService engage_interviewService;
	@Autowired
	private IConfig_major_kindService config_major_kindService;
	@Autowired
	private IEngage_resumeService  engage_resumeService;
	
	//��Ч�����б�Ǽ�
	@RequestMapping("Engage_interview_insert")
	private String Engage_interview_insert(Engage_interview engage_interview,Engage_resume engage_resume) {
		engage_interviewService.Engage_interview_insert(engage_interview);
		engage_interviewService.interview_update(engage_resume);
		return "redirect:Engage_resume_MSDJ";
	}
	
	//���Խ���Ǽ�
	@RequestMapping("Engage_interview_Er")
	public String Engage_interview_Er(Map map) {
		List<Config_major_kind> major = config_major_kindService.majorQuery();
		map.put("major", major);
		return "/recruit/interview/interview-resume";
	}
	
	//���Խ���б�
	@RequestMapping("Engage_interview_selresume")
	private String Engage_interview_selresume(@RequestParam Map map,Map map1) {
		List<Engage_interview> eil = engage_interviewService.selresume(map);
		map1.put("eil", eil);
		return "/recruit/interview/sift-list";
	}
	
	//����ɸѡ��ѯ
	@RequestMapping("Engage_interview_queryDan")
	private String Engage_interview_queryDan(Engage_interview engage_interview,int id,Map map) {
		Engage_interview ei = engage_interviewService.Engage_interview_queryDan(id);
		Engage_resume er =  engage_resumeService.Engage_resume_FUHE(ei.getResume_id());
		map.put("ei", ei);
		map.put("er", er);
		return "/recruit/interview/interview-sift";
	}
	
	//����ɸѡ����¼ȡ���
	@RequestMapping("Engage_interview_upd")
	private String Engage_interview_upd(Engage_interview engage_interview) {
		engage_interviewService.Engage_interview_upd(engage_interview);
		return "redirect:Engage_interview_Er";
	}
	
	//¼�������ѯ
	@RequestMapping("Engage_interview_query")
	private String Engage_interview_query(Map map) {
		List<Engage_interview> eil = engage_interviewService.Engage_interview_query();
		map.put("eil", eil);
		return "/recruit/employ/register_list";
	}
	
	//¼�������ѯ����ҳ��
	@RequestMapping("register_sift_queryDan")
	private String register_sift_queryDan(Engage_interview engage_interview,int id,Map map) {
		Engage_interview ei = engage_interviewService.Engage_interview_queryDan(id);
		Engage_resume er =  engage_resumeService.Engage_resume_FUHE(ei.getResume_id());
		map.put("ei", ei);
		map.put("er", er);
		return "/recruit/employ/register";
	}
	
	//¼ȡ����ͨ����ͨ��
	@RequestMapping("register_sift_update")
	private String register_sift_update(Engage_resume engage_resume) {
		engage_interviewService.register_sift_update(engage_resume);
		return "redirect:Engage_interview_query";
	}
	
	//¼����˲�ѯ
	@RequestMapping("check_list_query")
	private String check_list_query(Map map) {
		List<Engage_interview> eil = engage_interviewService.Engage_interview_query();
		map.put("eil", eil);
		return "/recruit/employ/check_list";
	}
	
	//¼����˲�ѯ����ҳ��
	@RequestMapping("check_list_queryDan")
	private String check_list_queryDan(Engage_interview engage_interview,int id,Map map) {
		Engage_interview ei = engage_interviewService.Engage_interview_queryDan(id);
		Engage_resume er =  engage_resumeService.Engage_resume_FUHE(ei.getResume_id());
		map.put("ei", ei);
		map.put("er", er);
		return "/recruit/employ/check";
	}
	
	//¼ȡ���ͨ����ͨ��
	@RequestMapping("check_list_update")
	private String check_list_update(Engage_resume engage_resume) {
		engage_interviewService.check_list_update(engage_resume);
		return "redirect:check_list_query";
	}
	
	//¼�ò�ѯ
	@RequestMapping("list_query")
	private String list_query(Map map) {
		List<Engage_interview> eil = engage_interviewService.Engage_interview_query();
		map.put("eil", eil);
		return "/recruit/employ/list";
	}
	
	//¼�ò�ѯ����ҳ��
	@RequestMapping("details_queryDan")
	private String details_queryDan(Engage_interview engage_interview,int id,Map map) {
		Engage_interview ei = engage_interviewService.Engage_interview_queryDan(id);
		Engage_resume er =  engage_resumeService.Engage_resume_FUHE(ei.getResume_id());
		map.put("ei", ei);
		map.put("er", er);
		return "/recruit/employ/details";
	}
}
