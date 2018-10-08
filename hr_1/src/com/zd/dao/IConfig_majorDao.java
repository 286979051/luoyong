package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_major;

public interface IConfig_majorDao {

	//职业分类二级联动 
	@Select("select * from Config_major where major_kind_id=#{id}")
	@ResultMap("Config_majormapper")
	public List<Config_major> ErMajorQuery(String id);
	
	//职业分类二级联动单查
	@Select("select * from Config_major where major_id=#{id}")
	@ResultMap("Config_majormapper")
	public Config_major ErMajorQueryDan(String id);
}
