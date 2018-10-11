package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Human_file;
import com.zd.entity.Salary_grant;
import com.zd.entity.Salary_grant_details;
import com.zd.entity.Salary_standard_details;
import com.zd.entity.zm_some;



public interface ISalary_grantService {

	
	
	//查一级机构名字，总金额，人数
	public List<Map> selFirst();
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
	
	
	//查一级机构总人数
	public int selFHuman();
	//查二级机构总人数
	public int selSHuman();
	//查三级机构总人数
	public int selTHuman();
	
	
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
	
	
	
	//查一档案编号和名字
	public List<Human_file> queryFHuman(String first_kind_name);
	//查二档案编号和名字
	public List<Human_file> querySHuman(String second_kind_name);
	//查三档案编号和名字
	public List<Human_file> queryTHuman(String third_kind_name);
	
	
	//查一级机构总人数
	public int queryFBCount(String first_kind_name);
	//查二级机构总人数
	public int querySBCount(String second_kind_name);
	//查三级机构总人数
	public int queryTBCount(String third_kind_name);
	
	//查基本薪酬总数
	public String selsum(String first_kind_name);
	
	
	//查项目名称
	public List<Config_public_char> selItem();
	
	//查薪酬标准单详细信息
	public List<Salary_standard_details> queryssd(String ssd);
	
	
	//查一级机构名
	public Config_file_first_kind selF(String first_kind_name);
	//查二级机构名
	public Config_file_second_kind selS(String second_kind_name);
	//查三级机构名
	public Config_file_third_kind selT(String third_kind_name);
	
	//添加薪酬发放详细信息
	public void addDetails(Salary_grant_details sgd);
	
	//添加薪酬发放登记表
	public void addgrant(Salary_grant sgt);
	
	
	//查薪酬发放登记表
	public List<Salary_grant> selAll();
	
	
}
