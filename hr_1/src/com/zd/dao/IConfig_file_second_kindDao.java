package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_file_second_kind;

public interface IConfig_file_second_kindDao {

	
	//二级联动
	@Select("select * from Config_file_second_kind where first_kind_id=#{id}")
	@ResultMap("Config_file_second_kindmapper")
	public List<Config_file_second_kind> queryById(int id);
}
