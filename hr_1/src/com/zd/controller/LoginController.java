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
	//注入service
	@Autowired
	private IUserService userservice;
	
		//登录
	@RequestMapping("/login")
	public String login(user u,HttpSession session) {
		//创建日志对象
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
					logger.error("登录失败", e);
				}
				return "redirect:login.jsp";
			}
	//退出登录
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return"redirect:login.jsp";
	}
	
	// 定义方法跳到jsp页面
		@RequestMapping({"/left","/main","/top"})
		public String toPage(HttpServletRequest req){
			// 获取请求地址
			String path = req.getServletPath();// /login
			path = path.substring(1, path.length());// login
			return path;
		}
	}

