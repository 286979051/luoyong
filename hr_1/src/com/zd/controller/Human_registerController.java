package com.zd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Human_registerController {
	
	// 定义方法跳到jsp页面
	@RequestMapping({"/human_register"})
	// login  test.jsp==>test
	public String toPagehr(HttpServletRequest req){
	// 获取请求地址
	String path = req.getServletPath();// /login
	return "humanResources"+path;
	}	
	
}
