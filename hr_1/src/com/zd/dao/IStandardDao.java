package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Salary_standard;
/**
 * 薪酬标准的制定过程
 * @author 张敏
 *
 */
import com.zd.entity.zm_some;
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
	@Select("SELECT COUNT(*) FROM salary_standard WHERE check_status = 2")
	public int selallSalary_count();	
	
	//进复核查询单条信息--基本信息
	@Select("SELECT * FROM salary_standard WHERE  ssd_id = #{ssd_id}")
	@ResultMap("salary_standardMapper")
	public Salary_standard selone_Salary_standard(int ssd_id);
	
	//进复核查询单条信息--项目信息
	public List<zm_some> selone_zmsome(String standard_id);

	//对复核信息进行修改_1
	@Update("UPDATE salary_standard SET standard_name=#{standard_name},designer=#{designer},checker=#{checker},check_time=#{check_time},salary_sum=#{salary_sum},check_status=1,check_comment=#{check_comment} WHERE standard_id=#{standard_id};")
	public void updfuhe(Salary_standard salary_standard);
	
	//对复核信息进行修改_2
	@Update("UPDATE zm_some  SET money = #{money} WHERE standard_id=#{standard_id} AND pbc_id = #{pbc_id}")
	public void updfuhe2(Map map);
	
	//对复核信息进行添加
	@Insert("INSERT INTO salary_standard_details VALUES(NULL,#{standard_id},#{standard_name},#{item_id},#{item_name},#{salary})")
	public void addfuhe(Map map);
	
	//薪酬标准查询——模糊查询
	public List<Salary_standard> selstatus1(Map map);
	
	//薪酬标准查询——模糊查询总条数
	public int selcount(Map map);
	
	//根据编号查询——查询薪酬标准
	@Select("SELECT * FROM salary_standard WHERE standard_id = #{standard_id}")
	@ResultMap("salary_standardMapper")
	public Salary_standard selbyid(String standard_id);
	
	//薪酬标准查询变更——模糊查询 
	public List<Salary_standard> selstatus2(Map map);
	
	//对变更信息进行修改_1
	@Update("UPDATE salary_standard SET standard_name=#{standard_name},designer=#{designer},changer=#{changer},change_time=#{change_time},salary_sum=#{salary_sum},remark=#{remark} WHERE standard_id=#{standard_id};")
	public void updbiangeng(Salary_standard salary_standard);
}
