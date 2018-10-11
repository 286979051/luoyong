package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Human_file;
import com.zd.entity.Salary_grant;
import com.zd.entity.Salary_grant_details;
import com.zd.entity.Salary_standard_details;
import com.zd.entity.zm_some;

/**
 * 薪酬发放登记表
 * @author Administrator
 *
 */
public interface ISalary_grantDao {

	
	
	//查一级机构名字，总金额，人数
	@Select("SELECT first_kind_name fname,SUM(salary_sum) fsum,COUNT(first_kind_name) fcount FROM human_file GROUP BY first_kind_name")
	@ResultMap("mapMapper")
	public List<Map> selFirst();
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
	
	
	//查一级机构总人数
	@Select("SELECT COUNT(*) FROM human_file GROUP BY first_kind_name !=''")
	public int selFHuman();
	//查二级机构总人数
	@Select("SELECT COUNT(*) FROM human_file GROUP BY second_kind_name !=''")
	public int selSHuman();
	//查三级机构总人数
	@Select("SELECT COUNT(*) FROM human_file GROUP BY third_kind_name !=''")
	public int selTHuman();
	
	
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
	
	
	//查一档案编号和名字
	@Select("SELECT human_id,human_name,salary_standard_id FROM human_file WHERE first_kind_name=#{first_kind_name} ")
	@ResultMap("humanMapper")
	public List<Human_file> queryFHuman(String first_kind_name);
	//查二档案编号和名字
	@Select("SELECT human_id,human_name,salary_standard_id FROM human_file WHERE second_kind_name=#{second_kind_name} ")
	@ResultMap("humanMapper")
	public List<Human_file> querySHuman(String second_kind_name);
	//查三档案编号和名字
	@Select("SELECT human_id,human_name,salary_standard_id FROM human_file WHERE third_kind_name=#{third_kind_name} ")
	@ResultMap("humanMapper")
	public List<Human_file> queryTHuman(String third_kind_name);
	
	
	//查一级机构总人数
	@Select("SELECT COUNT(*) FROM human_file WHERE first_kind_name=#{first_kind_name}")
	public int queryFBCount(String first_kind_name);
	//查二级机构总人数
	@Select("SELECT COUNT(*) FROM human_file WHERE second_kind_name=#{second_kind_name}")
	public int querySBCount(String second_kind_name);
	//查二级机构总人数
	@Select("SELECT COUNT(*) FROM human_file WHERE third_kind_name=#{third_kind_name}")
	public int queryTBCount(String third_kind_name);
	
	
	//查基本薪酬总数
	@Select("SELECT sum(salary_sum) FROM human_file WHERE first_kind_name=#{first_kind_name}")
	public String selsum(String first_kind_name);
	

	//查项目名称
	@Select("SELECT * FROM config_public_char WHERE attribute_kind='薪酬设置'")
	public List<Config_public_char> selItem();
	
	//查薪酬标准单详细信息
	@Select("SELECT * FROM Salary_standard_details WHERE standard_id=#{ssd}")
	@ResultMap("salary_standard_detailsMapper")
	public List<Salary_standard_details> queryssd(String ssd);
	
	
	//查一级机构名
	@Select("SELECT * FROM config_file_first_kind WHERE first_kind_name=#{first_kind_name}")
	@ResultMap("firstMapper")
	public Config_file_first_kind selF(String first_kind_name);
	//查二级机构名
	@Select("SELECT * FROM config_file_second_kind WHERE second_kind_name=#{second_kind_name}")
	@ResultMap("secondMapper")
	public Config_file_second_kind selS(String second_kind_name);
	//查三级机构名
	@Select("SELECT * FROM config_file_third_kind WHERE third_kind_name=#{third_kind_name}")
	@ResultMap("thirdMapper")
	public Config_file_third_kind selT(String third_kind_name);
	
	
	
	//添加薪酬发放详细信息
	@Insert("insert into salary_grant_details values(null,#{salary_grant_id},#{human_id},#{human_name},#{bouns_sum},#{sale_sum},#{deduct_sum},#{salary_standard_sum},#{salary_paid_sum})")
	public void addDetails(Salary_grant_details sgd);
	
	
	//添加薪酬发放登记表
	@Insert("insert into salary_grant values(null,#{salary_grant_id},#{salary_standard_id},#{first_kind_id},#{first_kind_name},#{second_kind_id},#{second_kind_name},#{third_kind_id},#{third_kind_name},#{human_amount},#{salary_standard_sum},#{salary_paid_sum},#{register},#{regist_time},null,null,1)")
	public void addgrant(Salary_grant sgt);
	
	
	//查薪酬发放登记表
	@Select("SELECT * FROM salary_grant WHERE check_status='1' ")
	@ResultMap("Salary_grantMapper")
	public List<Salary_grant> selAll();
	
	
	
	//查发放登记表
	@Select("SELECT * FROM salary_grant WHERE salary_grant_id=#{salary_grant_id}")
	@ResultMap("Salary_grantMapper")
	public Salary_grant selsds(String salary_grant_id);
	
	
	//发放详单
	@Select("SELECT a.salary_standard_id,b.* FROM salary_grant a,salary_grant_details b WHERE a.salary_grant_id = b.salary_grant_id AND a.salary_grant_id=#{salary_grant_id}")
	@ResultMap("detailsMapper1")
	public List<Salary_grant_details> selSgds(String salary_grant_id);
	
	
	//复核
	@Update("UPDATE salary_grant SET salary_standard_sum=#{salary_standard_sum},salary_paid_sum=#{salary_paid_sum},register=#{register},regist_time=#{regist_time},checker=#{checker},check_time=#{check_time},check_status=2 where salary_grant_id=#{salary_grant_id}")
	public void update(Salary_grant salary_grant_id);
	
	
	//薪酬查询
	public List<Salary_grant> selLikeSalary_grant(Map map);
	
	
	//
	
}
