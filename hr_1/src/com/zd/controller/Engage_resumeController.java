package com.zd.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.ls.LSInput;

import com.zd.entity.Config_major_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Engage_resume;
import com.zd.service.IConfig_majorService;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IConfig_public_charservice;
import com.zd.service.IEngage_resumeService;

@Controller
public class Engage_resumeController {

	@Autowired
	private IEngage_resumeService engage_resumeService;
	@Autowired
	private IConfig_major_kindService config_major_kindService;
	@Autowired
	private IConfig_majorService config_majorService;
	@Autowired
	private IConfig_public_charservice config_public_charservice;
	//简历登记
	@RequestMapping("Engage_resume_Insert")
	private String Engage_resume_Insert(Engage_resume engage_resume) {
		engage_resume.setHuman_major_kind_name(config_major_kindService.majorQueryDan(engage_resume.getHuman_major_kind_id()).getMajor_kind_name());
		engage_resume.setHuman_major_name(config_majorService.ErMajorQueryDan(engage_resume.getHuman_major_id()).getMajorname());
		engage_resumeService.Engage_resume_Insert(engage_resume);
		return "redirect:Engage_resume_Er";
	}
	//简历筛选查询
	@RequestMapping("Engage_resume_Er")
	public String Engage_resume_Er(Map map) {
		List<Config_major_kind> major = config_major_kindService.majorQuery();
		map.put("major", major);
		return "/recruit/resume/resume-choose";
	}
	//简历筛选模糊查询
	@RequestMapping("Engage_resume_MoHu")
	private String Engage_resume_MoHu(@RequestParam Map map,Map map1,HttpSession session) {
		if(map==null||map.size()<1) {
			Map map2=(Map) session.getAttribute("map");
			List<Engage_resume> EnList = engage_resumeService.selresume(map2);
			map1.put("EnList", EnList);
		}else {
			session.removeAttribute("map");
			List<Engage_resume> EnList = engage_resumeService.selresume(map);
			session.setAttribute("map",map);
			map1.put("EnList", EnList);
		}

		return "/recruit/resume/resume-list";
	}
	
	//有效简历查询
	@RequestMapping("Engage_resume_ErYXJL")
	public String Engage_resume_ErYXJL(Map map) {
		List<Config_major_kind> major = config_major_kindService.majorQuery();
		map.put("major", major);
		return "/recruit/resume/valid-resume";
	}
	//有效简历模糊查询
	@RequestMapping("Engage_resume_YXJL")
	private String Engage_resume_YXJL(@RequestParam Map map,Map map1) {
		List<Engage_resume> EnList = engage_resumeService.selresume(map);
		map1.put("EnList", EnList);
		return "/recruit/resume/valid-list";
	}
	
	//面试登记查询
	@RequestMapping("Engage_resume_MSDJ")
	private String Engage_resume_MSDJ(@RequestParam Map map,Map map1) {
		List<Engage_resume> EnList = engage_resumeService.selresume(map);
		map1.put("EnList", EnList);
		return "/recruit/interview/interview-list";
	}
	//查询面试 登记结果
	@RequestMapping("Engage_resume_DJJG")
	private String Engage_resume_DJJG(int id,Map map) {
		Engage_resume er = engage_resumeService.Engage_resume_FUHE(id);
		map.put("er", er);
		return "/recruit/interview/interview-register";
	}	
	
	//查询简历筛选页面
	@RequestMapping("Engage_resume_FUHE")
	private String Engage_resume_FUHE(int id,Map map) {
		List<Config_major_kind> cmkL = config_major_kindService.majorQuery();
		List<Config_public_char> cpcl = config_public_charservice.queryall();
		Engage_resume er = engage_resumeService.Engage_resume_FUHE(id);
		map.put("cpcl", cpcl);
		map.put("cmkL", cmkL);
		map.put("er", er);
		return "/recruit/resume/resume-details";
	}
	
	//查询简历筛选信息
		@RequestMapping("Engage_resume_SXXX")
		private String Engage_resume_SXXX(int id,Map map) {
			Engage_resume er = engage_resumeService.Engage_resume_FUHE(id);
			map.put("er", er);
			return "/recruit/resume/resume-select";
		}
	
	//筛选简历
	@RequestMapping("Engage_resume_Update")
	public String Engage_resume_Update(Engage_resume engage_resume) {
		engage_resume.setHuman_major_kind_name(config_major_kindService.majorQueryDan(engage_resume.getHuman_major_kind_id()).getMajor_kind_name());
		engage_resume.setHuman_major_name(config_majorService.ErMajorQueryDan(engage_resume.getHuman_major_id()).getMajorname());
		engage_resumeService.Engage_resume_Update(engage_resume);
		return "redirect:Engage_resume_MoHu";
	}
	
}
