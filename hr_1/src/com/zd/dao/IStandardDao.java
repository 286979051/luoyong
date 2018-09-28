package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Salary_standard;
/**
 * 薪酬标准的制定过程
 * @author 张敏
 *
 */
public interface IStandardDao {

	//添加薪酬的基本信息
	@Insert("INSERT INTO salary_standard VALUES(NULL,#{standard_id},#{standard_name},#{designer},#{register},NULL,NULL,#{regist_time},NULL,NULL,#{salary_sum},2,0,NULL,#{remark})")
	public void addstandard(Salary_standard salary_standard);
	
	//添加薪酬项目
	@Insert("INSERT INTO zm_some VALUES(#{standard_id},#{pbc_id},#{money})")
	public void addzm_some(Map map);
	
	//薪酬标准登记复核分页查询
	public List<Salary_standard> selallSalary(int start);
	
	//薪酬标准登记复核分页查询信息总数
	@Select("SELECT COUNT(*) FROM salary_standard")
	public int selallSalary_count();		
}
