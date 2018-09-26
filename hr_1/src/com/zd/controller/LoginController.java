package com.zd.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zd.entity.user;
import com.zd.service.IUserService;

@Controller
public class LoginController {
	//ע��service
	@Autowired
	private IUserService userservice;
	
		//��¼
	@RequestMapping("/login")
	public String login(user u,HttpSession session) {
		//������־����
			 Logger logger = LoggerFactory.getLogger(LoginController.class);
				try {
					user user1 = userservice.login(u);
					if(user1 != null){
						session.setAttribute("user", user1);
						return "index";
					}
					else{
						return "redirect:login.jsp";
					}
				} catch (Exception e) {
					logger.error("��¼ʧ��", e);
				}
				return "redirect:login.jsp";
			}
	//�˳���¼
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return"redirect:login.jsp";
	}
	
	// ���巽������jspҳ��
		@RequestMapping({"/left","/main","/top"})
		public String toPage(HttpServletRequest req){
			// ��ȡ�����ַ
			String path = req.getServletPath();// /login
			path = path.substring(1, path.length());// login
			return path;
		}
	}

