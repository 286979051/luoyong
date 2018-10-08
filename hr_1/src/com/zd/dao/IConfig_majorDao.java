package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_major;

public interface IConfig_majorDao {

	//ְҵ����������� 
	@Select("select * from Config_major where major_kind_id=#{id}")
	@ResultMap("Config_majormapper")
	public List<Config_major> ErMajorQuery(String id);
	
	//ְҵ���������������
	@Select("select * from Config_major where major_id=#{id}")
	@ResultMap("Config_majormapper")
	public Config_major ErMajorQueryDan(String id);
}
