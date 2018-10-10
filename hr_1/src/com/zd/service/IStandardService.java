package com.zd.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import com.zd.entity.Salary_standard;
import com.zd.entity.Salary_standard_details;
import com.zd.entity.zm_some;
/**
 * 
 * @author 张敏
 *
 */
@Service
public interface IStandardService {
	
	public void addstandard(Salary_standard salary_standard);
	
	public void addzm_some(Map map);
	
	//薪酬标准登记复核分页查询信息总数
	public int selallSalary_count();
	
	//薪酬标准登记复核分页查询
	public List<Salary_standard> selallSalary(int start);
	
	//进复核查询单条信息
	public Salary_standard selone_Salary_standard(int ssd_id);
	
	//进复核查询单条信息--项目信息
	public List<zm_some> selone_zmsome(String standard_id);
	
	//对复核信息进行修改
	public void updfuhe(Salary_standard salary_standard);
	
	//对复核信息进行修改_2
	public void updfuhe2(Map map);
	
	//对复核信息进行添加
	public void addfuhe(Map map);
	
	//薪酬标准查询——模糊查询
	public List<Salary_standard> selstatus1(Map map);
	
	//薪酬标准查询——模糊查询总条数
	public int selcount(Map map);
	
	//根据编号查询——查询薪酬标准
	public Salary_standard selbyid(String standard_id);
	
	//薪酬标准查询变更——模糊查询 
	public List<Salary_standard> selstatus2(Map map);
	
	//对变更信息进行修改_1
	public void updbiangeng(Salary_standard salary_standard);
	//查询所有
	public List<Salary_standard_details> selSalaryall();
	//查询单挑
	public Salary_standard_details selSalaryone(String id);
}
