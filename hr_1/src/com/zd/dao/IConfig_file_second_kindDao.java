package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;

public interface IConfig_file_second_kindDao {

	
	//二级联动
	@Select("select * from Config_file_second_kind where first_kind_id=#{id}")
	@ResultMap("Config_file_second_kindmapper")
	public List<Config_file_second_kind> queryById(String id);
	
	//查询所有二级机构
	@Select("select * from Config_file_second_kind")
	@ResultMap("Config_file_second_kindmapper")
	public List<Config_file_second_kind> selall();
	
	//添加之前查询所有一级机构名称
	@Select("select * from config_file_first_kind")
	@ResultMap("Config_file_first_kindmapper")
	public List<Config_file_first_kind> selallfirstname();
	
	//添加二级机构
	@Insert("insert into Config_file_second_kind values(null,#{firstkindid},#{firstkindname},#{secondkindid},#{secondkindname},#{secondsalaryid},#{secondsaleid})")
	public void addsecond(Config_file_second_kind secondkind);
	//二级联动单查
	@Select("select * from Config_file_second_kind where second_kind_id=#{id}")
	@ResultMap("Config_file_second_kindmapper")
	public Config_file_second_kind queryDan(String id);
	
	//修改二级机构前做查询
	@Select("select * from Config_file_second_kind where fsk_id=#{fskid}")
	@ResultMap("Config_file_second_kindmapper")
	public Config_file_second_kind selbyfskid(int fskid);
	
	//修改二级机构
	@Update("update Config_file_second_kind set second_salary_id=#{secondsalaryid},second_sale_id=#{secondsaleid} where fsk_id=#{fskid}")
	public void updatesecondkind(Config_file_second_kind secondkind);
	
	//删除二级机构
	@Delete("delete from Config_file_second_kind where second_kind_id=#{secondkindid}")
	public void deletesecond(String secondkindid);
	
	//删除二级机构的同时删除三级机构
	@Delete("delete from Config_file_third_kind where second_kind_id=#{secondkindid}")
	public void delete2(String secondkindid);
	
	//根据secondkindid查询二级(单条查询,用于三级添加)
	@Select("select * from Config_file_second_kind where second_kind_id=#{secondkindid}")
	@ResultMap("Config_file_second_kindmapper")
	public  Config_file_second_kind selbysecondkindid(String secondkindid);
	
	
}
