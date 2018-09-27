package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_file_first_kind;

public interface IConfig_file_first_kindDao {

	//一级机构联动
	@Select("select * from Config_file_first_kind")
	@ResultMap("Config_file_first_kindmapper")
	public List<Config_file_first_kind> query();
	
	//一级机构联动单条查询
	@Select("select * from Config_file_first_kind where first_kind_id=#{first_kind_id}")
	@ResultMap("Config_file_first_kindmapper")
	public Config_file_first_kind queryDan(int first_kind_id);
}
