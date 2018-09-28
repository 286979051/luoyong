package com.zd.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zd.entity.Salary_standard;
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
}
