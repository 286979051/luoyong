package com.zd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Human_registerController {
	
	// ���巽������jspҳ��
	@RequestMapping({"/human_register"})
	// login  test.jsp==>test
	public String toPagehr(HttpServletRequest req){
	// ��ȡ�����ַ
	String path = req.getServletPath();// /login
	return "humanResources"+path;
	}	
	
}
