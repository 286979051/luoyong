package com.zd.service;

import java.util.List;
import java.util.Map;



public interface ISalary_grantService {

	
	
	//查一级机构名字，总金额，人数
	public List<Map> selFist();
	//查二级机构名字，总金额，人数
	public List<Map> selSecond();
	//查三级机构名字，总金额，人数
	public List<Map> selThird();
	
	
	//查薪酬总数
	public int selFCount();
	//查薪酬总数
	public int selSCount();
	//查薪酬总数
	public int selTCount();
	
	
	//查总人数
	public int selHuman();
	
	
	//查基本薪酬总数(一级)
	public String selFMoney();
	//查基本薪酬总数(二级)
	public String selSMoney();
	//查基本薪酬总数(三级)
	public String selTMoney();
	
	
	//查实发总额(一级)
	public String selFShiMoney();
	//查实发总额(二级)
	public String selSShiMoney();
	//查实发总额(三级)
	public String selTShiMoney();
}
