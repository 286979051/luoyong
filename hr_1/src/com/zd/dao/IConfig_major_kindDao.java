package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_major_kind;

public interface IConfig_major_kindDao {

	//ְҵ����һ������
	@Select("select * from Config_major_kind")
	@ResultMap("Config_major_kindmapper")
	public List<Config_major_kind> majorQuery();
	
	//ְҵ����һ����������
	@Select("select * from Config_major_kind where major_kind_id=#{id}")
	@ResultMap("Config_major_kindmapper")
	public Config_major_kind majorQueryDan(int id);
}
