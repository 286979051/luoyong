package com.zd.controller;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zd.entity.Config_major_kind;
import com.zd.entity.Engage_interview;
import com.zd.entity.Engage_resume;
import com.zd.entity.e_mail;
import com.zd.entity.mail;
import com.zd.service.IConfig_major_kindService;
import com.zd.service.IEngage_interviewService;
import com.zd.service.IEngage_resumeService;
import com.zd.service.Ie_mailService;
import com.zd.service.impl.Config_major_kindService;

@Controller
public class Engage_interviewController {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private IEngage_interviewService engage_interviewService;
	@Autowired
	private IConfig_major_kindService config_major_kindService;
	@Autowired
	private IEngage_resumeService  engage_resumeService;
	@Autowired
	private Ie_mailService e_mailService;
	//有效简历列表登记
	@RequestMapping("Engage_interview_insert")
	private String Engage_interview_insert(Engage_interview engage_interview,Engage_resume engage_resume) {
		engage_interviewService.Engage_interview_insert(engage_interview);
		engage_interviewService.interview_update(engage_resume);
		return "redirect:Engage_resume_MSDJ";
	}
	
	//面试结果登记
	@RequestMapping("Engage_interview_Er")
	public String Engage_interview_Er(Map map) {
		List<Config_major_kind> major = config_major_kindService.majorQuery();
		map.put("major", major);
		return "/recruit/interview/interview-resume";
	}
	
	//面试结果列表
	@RequestMapping("Engage_interview_selresume")
	private String Engage_interview_selresume(@RequestParam Map map,Map map1,HttpSession session) {
		if(map==null||map.size()<1) {
			Map map2=(Map) session.getAttribute("map");
			List<Engage_interview> eil = engage_interviewService.selresume(map2);
			map1.put("eil", eil);
		}else {
			session.removeAttribute("map");
			List<Engage_interview> eil = engage_interviewService.selresume(map);
			session.setAttribute("map",map);
			map1.put("eil", eil);
		}
		return "/recruit/interview/sift-list";
	}
	
	//面试筛选查询
	@RequestMapping("Engage_interview_queryDan")
	private String Engage_interview_queryDan(Engage_interview engage_interview,int id,Map map) {
		Engage_interview ei = engage_interviewService.Engage_interview_queryDan(id);
		Engage_resume er =  engage_resumeService.Engage_resume_FUHE(ei.getResume_id());
		map.put("ei", ei);
		map.put("er", er);
		return "/recruit/interview/interview-sift";
	}
	
	//面试筛选附加录取意见
	@RequestMapping("Engage_interview_upd")
	private String Engage_interview_upd(Engage_interview engage_interview) {
		engage_interviewService.Engage_interview_upd(engage_interview);
		return "redirect:Engage_interview_selresume";
	}
	
	//查询E-mail邮件模板显示
	@RequestMapping("E_mailQuery")
	private String E_mailQuery(Map map,int id){
		List<e_mail> eList = e_mailService.selalle_mail();
		Engage_resume er =  engage_resumeService.Engage_resume_FUHE(id);
		map.put("er", er);
		map.put("eList", eList);
		return "/recruit/resume/E_mail";
	}
	
	//发送电子邮件
	@RequestMapping("sendEmail")
	public String sendEmail(mail mai,int emailTitle) throws Exception {
			e_mail email = e_mailService.e_mailQuery(emailTitle);
			// 1、通过发送者创建电子邮件对象-MimeMessage
			MimeMessage mm = mailSender.createMimeMessage();
			// 2、创建发送电子邮件的帮助者对象-MimeMessageHelper
			MimeMessageHelper helper = new MimeMessageHelper(mm, "UTF-8");
			// 3、设置发送电子邮件的相关信息
			// 3-1 指定发件人
			helper.setFrom(mai.getSenderEmail());
			// 3-2 指定收件人
			helper.setTo(mai.getHuman_email());
			// 3-3 指定邮件主题
			helper.setSubject(email.getE_title());
			// 3-4 指定邮件内容,上了true表示支持html
			helper.setText(mai.getEidaa(), true);
			// 4、通过邮件发送者发送电子邮件
			mailSender.send(mm);
			return "redirect:Engage_interview_selresume"; 
	}
	
	//录用申请查询
	@RequestMapping("Engage_interview_query")
	private String Engage_interview_query(Map map) {
		List<Engage_interview> eil = engage_interviewService.Engage_interview_query();
		map.put("eil", eil);
		return "/recruit/employ/register_list";
	}
	
	//录用申请查询单条页面
	@RequestMapping("register_sift_queryDan")
	private String register_sift_queryDan(Engage_interview engage_interview,int id,Map map) {
		Engage_interview ei = engage_interviewService.Engage_interview_queryDan(id);
		Engage_resume er =  engage_resumeService.Engage_resume_FUHE(ei.getResume_id());
		map.put("ei", ei);
		map.put("er", er);
		return "/recruit/employ/register";
	}
	
	//录取申请通过或不通过
	@RequestMapping("register_sift_update")
	private String register_sift_update(Engage_resume engage_resume) {
		engage_interviewService.register_sift_update(engage_resume);
		return "redirect:Engage_interview_query";
	}
	
	//录用审核查询
	@RequestMapping("check_list_query")
	private String check_list_query(Map map) {
		List<Engage_interview> eil = engage_interviewService.Engage_interview_query();
		map.put("eil", eil);
		return "/recruit/employ/check_list";
	}
	
	//录用审核查询单条页面
	@RequestMapping("check_list_queryDan")
	private String check_list_queryDan(Engage_interview engage_interview,int id,Map map) {
		Engage_interview ei = engage_interviewService.Engage_interview_queryDan(id);
		Engage_resume er =  engage_resumeService.Engage_resume_FUHE(ei.getResume_id());
		map.put("ei", ei);
		map.put("er", er);
		return "/recruit/employ/check";
	}
	
	//录取审核通过或不通过
	@RequestMapping("check_list_update")
	private String check_list_update(Engage_resume engage_resume) {
		engage_interviewService.check_list_update(engage_resume);
		return "redirect:check_list_query";
	}
	
	//录用查询
	@RequestMapping("list_query")
	private String list_query(Map map) {
		List<Engage_interview> eil = engage_interviewService.Engage_interview_query();
		map.put("eil", eil);
		return "/recruit/employ/list";
	}
	
	//录用查询单条页面
	@RequestMapping("details_queryDan")
	private String details_queryDan(Engage_interview engage_interview,int id,Map map) {
		Engage_interview ei = engage_interviewService.Engage_interview_queryDan(id);
		Engage_resume er =  engage_resumeService.Engage_resume_FUHE(ei.getResume_id());
		map.put("ei", ei);
		map.put("er", er);
		return "/recruit/employ/details";
	}
	
	//查询E-mail邮件模板显示
	@RequestMapping("E_mailQueryMa")
	private String E_mailQueryMa(Map map,int id){
		List<e_mail> eList = e_mailService.selalle_mail();
		Engage_resume er =  engage_resumeService.Engage_resume_FUHE(id);
		map.put("er", er);
		map.put("eList", eList);
		return "/recruit/employ/E_mail";
	}
	
	//发送电子邮件
	@RequestMapping("sendEmailMa")
	public String sendEmailMa(mail mai,int emailTitle) throws Exception {
				e_mail email = e_mailService.e_mailQuery(emailTitle);
				// 1、通过发送者创建电子邮件对象-MimeMessage
				MimeMessage mm = mailSender.createMimeMessage();
				// 2、创建发送电子邮件的帮助者对象-MimeMessageHelper
				MimeMessageHelper helper = new MimeMessageHelper(mm, "UTF-8");
				// 3、设置发送电子邮件的相关信息
				// 3-1 指定发件人
				helper.setFrom(mai.getSenderEmail());
				// 3-2 指定收件人
				helper.setTo(mai.getHuman_email());
				// 3-3 指定邮件主题
				helper.setSubject(email.getE_title());
				// 3-4 指定邮件内容,上了true表示支持html
				helper.setText(mai.getEidaa(), true);
				// 4、通过邮件发送者发送电子邮件
				mailSender.send(mm);
				return "redirect:list_query"; 
	}
}
