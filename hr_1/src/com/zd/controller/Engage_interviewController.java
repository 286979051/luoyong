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
		return "redirect:Engage_interview_selresume";
	}
	
	//��ѯE-mail�ʼ�ģ����ʾ
	@RequestMapping("E_mailQuery")
	private String E_mailQuery(Map map,int id){
		List<e_mail> eList = e_mailService.selalle_mail();
		Engage_resume er =  engage_resumeService.Engage_resume_FUHE(id);
		map.put("er", er);
		map.put("eList", eList);
		return "/recruit/resume/E_mail";
	}
	
	//���͵����ʼ�
	@RequestMapping("sendEmail")
	public String sendEmail(mail mai,int emailTitle) throws Exception {
			e_mail email = e_mailService.e_mailQuery(emailTitle);
			// 1��ͨ�������ߴ��������ʼ�����-MimeMessage
			MimeMessage mm = mailSender.createMimeMessage();
			// 2���������͵����ʼ��İ����߶���-MimeMessageHelper
			MimeMessageHelper helper = new MimeMessageHelper(mm, "UTF-8");
			// 3�����÷��͵����ʼ��������Ϣ
			// 3-1 ָ��������
			helper.setFrom(mai.getSenderEmail());
			// 3-2 ָ���ռ���
			helper.setTo(mai.getHuman_email());
			// 3-3 ָ���ʼ�����
			helper.setSubject(email.getE_title());
			// 3-4 ָ���ʼ�����,����true��ʾ֧��html
			helper.setText(mai.getEidaa(), true);
			// 4��ͨ���ʼ������߷��͵����ʼ�
			mailSender.send(mm);
			return "redirect:Engage_interview_selresume"; 
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
	
	//��ѯE-mail�ʼ�ģ����ʾ
	@RequestMapping("E_mailQueryMa")
	private String E_mailQueryMa(Map map,int id){
		List<e_mail> eList = e_mailService.selalle_mail();
		Engage_resume er =  engage_resumeService.Engage_resume_FUHE(id);
		map.put("er", er);
		map.put("eList", eList);
		return "/recruit/employ/E_mail";
	}
	
	//���͵����ʼ�
	@RequestMapping("sendEmailMa")
	public String sendEmailMa(mail mai,int emailTitle) throws Exception {
				e_mail email = e_mailService.e_mailQuery(emailTitle);
				// 1��ͨ�������ߴ��������ʼ�����-MimeMessage
				MimeMessage mm = mailSender.createMimeMessage();
				// 2���������͵����ʼ��İ����߶���-MimeMessageHelper
				MimeMessageHelper helper = new MimeMessageHelper(mm, "UTF-8");
				// 3�����÷��͵����ʼ��������Ϣ
				// 3-1 ָ��������
				helper.setFrom(mai.getSenderEmail());
				// 3-2 ָ���ռ���
				helper.setTo(mai.getHuman_email());
				// 3-3 ָ���ʼ�����
				helper.setSubject(email.getE_title());
				// 3-4 ָ���ʼ�����,����true��ʾ֧��html
				helper.setText(mai.getEidaa(), true);
				// 4��ͨ���ʼ������߷��͵����ʼ�
				mailSender.send(mm);
				return "redirect:list_query"; 
	}
}
