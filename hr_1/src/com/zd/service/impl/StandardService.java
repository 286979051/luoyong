package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IStandardDao;
import com.zd.dao.Salary_standard_details;
import com.zd.entity.Salary_standard;
import com.zd.entity.zm_some;
import com.zd.service.IStandardService;
/**
 * 
 * @author 张敏
 *
 */
@Service
public class StandardService implements IStandardService{
	@Autowired
	private IStandardDao dao;

	//添加薪酬基本信息
	public void addstandard(Salary_standard salary_standard) {
		dao.addstandard(salary_standard);
	}

	// 添加薪酬项目信息
	public void addzm_some(Map map) {
		dao.addzm_some(map);
		
	}

	//薪酬标准登记复核分页查询信息总数
	public int selallSalary_count() {
		return dao.selallSalary_count();
	}

	//薪酬标准登记复核分页查询
	public List<Salary_standard> selallSalary(int start) {
		return dao.selallSalary(start);
	}
	
	//进复核查询单条信息
	public Salary_standard selone_Salary_standard(int ssd_id) {
		return dao.selone_Salary_standard(ssd_id);
	}

	//进复核查询单条信息--项目信息
	public List<zm_some> selone_zmsome(String standard_id) {
		return dao.selone_zmsome(standard_id);
	}

	//对复核信息进行修改
	public void updfuhe(Salary_standard salary_standard) {
		dao.updfuhe(salary_standard);
	}
	
	//对复核信息进行修改_2
	public void updfuhe2(Map map) {
		dao.updfuhe2(map);
	}

	//对复核信息进行添加
	public void addfuhe(Map map) {
		dao.addfuhe(map);
		
	}

}

