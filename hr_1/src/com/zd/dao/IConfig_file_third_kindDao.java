package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;

public interface IConfig_file_third_kindDao {

	//三级联动
	@Select("select * from Config_file_third_kind where second_kind_id=#{id}")
	@ResultMap("Config_file_third_kindmapper")
	public List<Config_file_third_kind> queryById(String id);
	//三级联动单查
	@Select("select * from Config_file_third_kind where third_kind_id=#{id}")
	@ResultMap("Config_file_third_kindmapper")
	public Config_file_third_kind queryDan(String id);
	
	//查询所有三级机构
	@Select("select * from Config_file_third_kind")
	@ResultMap("Config_file_third_kindmapper")
	public List<Config_file_third_kind> selallthirdkind();
	//添加前查询一级机构
	@Select("select * from Config_file_first_kind")
	@ResultMap("Config_file_first_kindmapper")
	public List<Config_file_first_kind> selallfirst();
	//添加之前查询所有的二级机构
	@Select("select * from Config_file_second_kind")
	@ResultMap("Config_file_second_kindmapper")
	public List<Config_file_second_kind> selallsecond();
	//添加三级机构
	@Insert("insert into Config_file_third_kind values(null,#{firstkindid},#{firstkindname},#{secondkindid},#{secondkindname},#{thirdkindid},#{thirdkindname},#{thirdkindsaleid},#{thirdkindisretail})")
	public void addthirdkind(Config_file_third_kind thirdkind);
	//修改之前查询
	@Select("select * from Config_file_third_kind where ftk_id=#{ftkid}")
	@ResultMap("Config_file_third_kindmapper")
	public Config_file_third_kind selthirdupdate(int ftkid);
	//修改三级机构
	@Update("update Config_file_third_kind set third_kind_sale_id=#{thirdkindsaleid},third_kind_is_retail=#{thirdkindisretail} where ftk_id=#{ftkid}")
	public void updatethird(Config_file_third_kind thirdkind);
	//删除三级机构
	@Delete("delete from Config_file_third_kind where ftk_id=#{ftkid}")
	public void deletethird(int ftkid);
	
}
