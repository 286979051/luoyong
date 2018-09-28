package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.ISalary_grantDao;
import com.zd.entity.Human_file;
import com.zd.entity.Salary_grant;
import com.zd.service.ISalary_grantService;

@Service
public class Salary_grantService implements ISalary_grantService {

	@Autowired
	private ISalary_grantDao salary_grantDao;

	
	//查一级机构名字，总金额，人数
	public List<Map> selFist() {
		return salary_grantDao.selFist();
	}
	//查二级机构名字，总金额，人数
	public List<Map> selSecond(){
		return salary_grantDao.selSecond();
	}
	//查三级机构名字，总金额，人数
	public List<Map> selThird(){
		return salary_grantDao.selThird();
	}
	
	
	//查薪酬总数
	public int selFCount() {
		return salary_grantDao.selFCount();
	}
	//查薪酬总数
	public int selSCount() {
		return salary_grantDao.selSCount();
	}
	//查薪酬总数
	public int selTCount() {
		return salary_grantDao.selTCount();
	}
	
	
	//查总人数
	public int selHuman() {
		return salary_grantDao.selHuman();
	}
	
	
	//查基本薪酬总数(一级)
	public double selFMoney() {
		return salary_grantDao.selFMoney();
	}
	//查基本薪酬总数(二级)
	public double selSMoney() {
		return salary_grantDao.selSMoney();
	}
	//查基本薪酬总数(三级)
	public double selTMoney() {
		return salary_grantDao.selTMoney();
	}
	
	
	//查实发总额(一级)
	public double selFShiMoney() {
		return salary_grantDao.selFShiMoney();
	}
	//查实发总额(二级)
	public double selSShiMoney() {
		return salary_grantDao.selSShiMoney();
	}
	//查实发总额(三级)
	public double selTShiMoney() {
		return salary_grantDao.selTShiMoney();
	}
}
