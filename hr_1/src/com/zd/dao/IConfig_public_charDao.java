package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_public_char;
/**
 * 公共表的Dao层
 * @author Administrator
 *
 */
public interface IConfig_public_charDao {
	//查询所有类型
	@Select("SELECT * FROM Config_public_char")
	@ResultMap("queryall")
	public List<Config_public_char> queryall();
	
	//zhangmin的查询薪酬设置中的公共字段
	@Select("SELECT * FROM config_public_char where attribute_kind = '薪酬设置'")
	@ResultMap("queryall")
	public List<Config_public_char> selsalary();
	
	//zhangmin的查询薪酬设置中的公共字段(一对一)
	public List<Config_public_char> selzm_some(int pbc_id);
	
	//查询招聘类型
	@Select("SELECT * FROM Config_public_char where attribute_kind='招聘类型'")
	@ResultMap("queryall")
	public List<Config_public_char> QueryEngageType();
	
	//查询招聘类型单条
	@Select("SELECT * FROM Config_public_char where pbc_id=#{id}")
	@ResultMap("queryall")
	public Config_public_char QueryEngageTypeDan(int id);
	
	//张紫行，查询所有职称
	@Select("select * from Config_public_char where attribute_kind='职称'")
	@ResultMap("queryall")
	public List<Config_public_char> selprofessiondesign();
	//张紫行，删除职称
	@Delete("delete from Config_public_char where pbc_id=#{pbc_id}")
	public void deleteprofession(int pbc_id);

}
