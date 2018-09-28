package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * 薪酬发放登记表
 * @author Administrator
 *
 */
public interface ISalary_grantDao {

	
	
	//查一级机构名字，总金额，人数
	@Select("SELECT first_kind_name fname,SUM(salary_sum) fsum,COUNT(first_kind_name) fcount FROM human_file GROUP BY first_kind_name")
	@ResultMap("mapMapper")
	public List<Map> selFist();
	//查二级机构名字，总金额，人数
	@Select("SELECT second_kind_name sname,SUM(salary_sum) ssum,COUNT(second_kind_name) scount FROM human_file GROUP BY second_kind_name")
	@ResultMap("mapMapper")
	public List<Map> selSecond();
	//查三级机构名字，总金额，人数
	@Select("SELECT third_kind_name tname,SUM(salary_sum) tsum,COUNT(third_kind_name) tcount FROM human_file GROUP BY third_kind_name")
	@ResultMap("mapMapper")
	public List<Map> selThird();
	
	
	//查薪酬总数
	@Select("SELECT COUNT(*) FROM (SELECT * FROM human_file GROUP BY first_kind_name) count")
	public int selFCount();
	//查薪酬总数
	@Select("SELECT COUNT(*) FROM (SELECT * FROM human_file GROUP BY second_kind_name) count")
	public int selSCount();
	//查薪酬总数
	@Select("SELECT COUNT(*) FROM (SELECT * FROM human_file GROUP BY third_kind_name) count")
	public int selTCount();
	
	
	//查总人数
	@Select("SELECT COUNT(*) FROM (SELECT * FROM human_file) aaa")
	public int selHuman();
	
	
	//查基本薪酬总数(一级)
	@Select("SELECT SUM(salary_sum) FROM human_file WHERE first_kind_name!=''")
	public String selFMoney();
	//查基本薪酬总数(二级)
	@Select("SELECT SUM(salary_sum) FROM human_file WHERE second_kind_name!=''")
	public String selSMoney();
	//查基本薪酬总数(三级)
	@Select("SELECT SUM(salary_sum) FROM human_file WHERE third_kind_name!=''")
	public String selTMoney();
	
	
	//查实发总额(一级)
	@Select("SELECT SUM(paid_salary_sum) FROM human_file WHERE first_kind_name!=''")
	public String selFShiMoney();
	//查实发总额(二级)
	@Select("SELECT SUM(paid_salary_sum) FROM human_file WHERE second_kind_name!=''")
	public String selSShiMoney();
	//查实发总额(三级)
	@Select("SELECT SUM(paid_salary_sum) FROM human_file WHERE third_kind_name!=''")
	public String selTShiMoney();
}
