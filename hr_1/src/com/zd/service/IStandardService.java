package com.zd.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import com.zd.entity.Salary_standard;
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
}
