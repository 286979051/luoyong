package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_file_third_kind;

public interface IConfig_file_third_kindDao {

	//三级联动
	@Select("select * from Config_file_third_kind where second_kind_id=#{id}")
	@ResultMap("Config_file_third_kindmapper")
	public List<Config_file_third_kind> queryById(int id);
	//三级联动单查
	@Select("select * from Config_file_third_kind where third_kind_id=#{id}")
	@ResultMap("Config_file_third_kindmapper")
	public Config_file_third_kind queryDan(int id);
}
