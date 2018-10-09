package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_public_char;
import com.zd.entity.Human_file;
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
	

	//查项目名称
	@Select("SELECT * FROM config_public_char WHERE attribute_kind='薪酬设置'")
	public List<Config_public_char> selItem();
	
	//查薪酬标准单详细信息
	@Select("SELECT * FROM Salary_standard_details WHERE standard_id=#{ssd}")
	@ResultMap("salary_standard_detailsMapper")
	public List<Salary_standard_details> queryssd(String ssd);
	
//	//添加登记
//	@Insert("insert")
	
}
