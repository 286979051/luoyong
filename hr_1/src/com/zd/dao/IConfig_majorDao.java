package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;

public interface IConfig_majorDao {

	//职业分类二级联动 
	@Select("select * from Config_major where major_kind_id=#{id}")
	@ResultMap("Config_majormapper")
	public List<Config_major> ErMajorQuery(String id);
	
	//职业分类二级联动单查
	@Select("select * from Config_major where major_id=#{id}")
	@ResultMap("Config_majormapper")
	public Config_major ErMajorQueryDan(int id);
	
	//张紫行，查询所有职位
	@Select("select * from Config_major")
	@ResultMap("Config_majormapper")
	public List<Config_major> selallConfig_major();
	
	//张紫行，删除职位
	@Delete("delete from Config_major where mak_id=#{makid}")
	public void deletemajor(int makid);
	
	//张紫行，添加职位
	@Insert("insert into Config_major values(null,#{majorkindid},#{majorkindname},#{majorid},#{majorname})")
	public void addConfig_major(Config_major Configmajor);
	
	//张紫行，根据职位分类id查询职位名称
	@Select("select * from Config_major_kind where major_kind_id=#{major_kind_id}")
	@ResultMap("Config_major_kindmapper")
	public Config_major_kind majorkindname(String majorkindid);
	public Config_major ErMajorQueryDan(String id);
}
