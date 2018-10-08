package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Config_file_first_kind;

public interface IConfig_file_first_kindDao {

	//一级机构联动
	@Select("select * from Config_file_first_kind")
	@ResultMap("Config_file_first_kindmapper")
	public List<Config_file_first_kind> query();
	//添加一级机构
	@Insert("insert into Config_file_first_kind values(null,#{firstkindid},#{firstkindname},#{firstkindsalaryid},#{firstkindsaleid})")
	public void add(Config_file_first_kind firstkind);
	//修改之前做查询
	@Select("select * from Config_file_first_kind where ffk_id=#{ffkid}")
	@ResultMap("Config_file_first_kindmapper")
	public Config_file_first_kind selbyffkid(int ffkid);
	//添加时查询一级机构名字
	@Select("select * from Config_file_first_kind where first_kind_id=#{firstkindid}")
	@ResultMap("Config_file_first_kindmapper")
	public Config_file_first_kind selbybhid(String firstkindid);
	//修改
	@Update("update Config_file_first_kind set first_kind_salary_id=#{firstkindsalaryid},first_kind_sale_id=#{firstkindsaleid} where ffk_id=#{ffkid}")
	public void update(Config_file_first_kind firstkind);
	//删除一级机构
	@Delete("delete from Config_file_first_kind where first_kind_id=#{firstkindid}")
	public void delete(String firstkindid);
	//删除一级机构的同时删除二级机构
	@Delete("delete from Config_file_second_kind where first_kind_id=#{firstkindid}")
	public void delete2(String firstkindid);
	//删除一级机构的同时删除二级机构以及三级机构
	@Delete("delete from Config_file_third_kind where first_kind_id=#{firstkindid}")
	public void delete3(String firstkindid);
	//一级机构联动单条查询
	@Select("select * from Config_file_first_kind where first_kind_id=#{first_kind_id}")
	@ResultMap("Config_file_first_kindmapper")
	public Config_file_first_kind queryDan(String first_kind_id);
}
