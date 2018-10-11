package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.ISalary_grantDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Human_file;
import com.zd.entity.Salary_grant;
import com.zd.entity.Salary_grant_details;
import com.zd.entity.Salary_standard_details;
import com.zd.entity.zm_some;
import com.zd.service.ISalary_grantService;

@Service
public class Salary_grantService implements ISalary_grantService {

	@Autowired
	private ISalary_grantDao salary_grantDao;

	
	//查一级机构名字，总金额，人数
	public List<Map> selFirst() {
		return salary_grantDao.selFirst();
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
	
	
	//查一级机构总人数
	public int selFHuman() {
		return salary_grantDao.selFHuman();
	}
	//查二级机构总人数
	public int selSHuman() {
		return salary_grantDao.selSHuman();
	}
	//查三级机构总人数
	public int selTHuman() {
		return salary_grantDao.selTHuman();
	}
	
	
	//查基本薪酬总数(一级)
	public String selFMoney() {
		return salary_grantDao.selFMoney();
	}
	//查基本薪酬总数(二级)
	public String selSMoney() {
		return salary_grantDao.selSMoney();
	}
	//查基本薪酬总数(三级)
	public String selTMoney() {
		return salary_grantDao.selTMoney();
	}
	
	
	//查实发总额(一级)
	public String selFShiMoney() {
		return salary_grantDao.selFShiMoney();
	}
	//查实发总额(二级)
	public String selSShiMoney() {
		return salary_grantDao.selSShiMoney();
	}
	//查实发总额(三级)
	public String selTShiMoney() {
		return salary_grantDao.selTShiMoney();
	}
	
	
	
	//查一档案编号和名字
	public List<Human_file> queryFHuman(String first_kind_name){
		return salary_grantDao.queryFHuman(first_kind_name);
	}
	//查二档案编号和名字
	public List<Human_file> querySHuman(String second_kind_name){
		return salary_grantDao.querySHuman(second_kind_name);
	}
	//查三档案编号和名字
	public List<Human_file> queryTHuman(String third_kind_name){
		return salary_grantDao.queryTHuman(third_kind_name);
	}
	
	
	//查一级机构总人数
	public int queryFBCount(String first_kind_name) {
		return salary_grantDao.queryFBCount(first_kind_name);
	}
	//查二级机构总人数
	public int querySBCount(String second_kind_name) {
		return salary_grantDao.querySBCount(second_kind_name);
	}
	//查三级机构总人数
	public int queryTBCount(String third_kind_name) {
		return salary_grantDao.queryTBCount(third_kind_name);
	}
	
	
	//查基本薪酬总数
	public String selsum(String first_kind_name) {
		return salary_grantDao.selsum(first_kind_name);
	}

	//查项目名称
	public List<Config_public_char> selItem(){
		return salary_grantDao.selItem();
	}
	
	
	//查薪酬标准单详细信息
	public List<Salary_standard_details> queryssd(String ssd){
		return salary_grantDao.queryssd(ssd);
	}
	
	
	//查一级机构名
	public Config_file_first_kind selF(String first_kind_name){
		return salary_grantDao.selF(first_kind_name);
	}
	//查二级机构名
	public Config_file_second_kind selS(String second_kind_name){
		return salary_grantDao.selS(second_kind_name);
	}
	//查三级机构名
	public Config_file_third_kind selT(String third_kind_name){
		return salary_grantDao.selT(third_kind_name);
	}
	
	
	//添加薪酬发放详细信息
	public void addDetails(Salary_grant_details sgd) {
		salary_grantDao.addDetails(sgd);
	}
	//添加薪酬发放登记表
	public void addgrant(Salary_grant sgt) {
		salary_grantDao.addgrant(sgt);
	}
	
	
	//查薪酬发放登记表
	public List<Salary_grant> selAll(){
		return salary_grantDao.selAll();
	}
	
	
	
}
