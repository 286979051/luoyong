package com.zd.dao;

import java.util.List;

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
	
	//查询招聘类型
	@Select("SELECT * FROM Config_public_char where attribute_kind='招聘类型'")
	@ResultMap("queryall")
	public List<Config_public_char> QueryEngageType();
	
	//查询国籍
	@Select("SELECT * FROM Config_public_char where attribute_kind='国籍'")
	@ResultMap("queryall")
	public List<Config_public_char> QueryEngageGuoJi();
	
	//查询民族
	@Select("SELECT * FROM Config_public_char where attribute_kind='民族'")
	@ResultMap("queryall")
	public List<Config_public_char> QueryEngageMinZu();
	
	//查询宗教信仰
	@Select("SELECT * FROM Config_public_char where attribute_kind='宗教信仰'")
	@ResultMap("queryall")
	public List<Config_public_char> QueryEngageZongJiao();
	
	//查询政治面貌
	@Select("SELECT * FROM Config_public_char where attribute_kind='政治面貌'")
	@ResultMap("queryall")
	public List<Config_public_char> QueryEngageMianMiao();
	
	//查询招聘类型单条
	@Select("SELECT * FROM Config_public_char where pbc_id=#{id}")
	@ResultMap("queryall")
	public Config_public_char QueryEngageTypeDan(int id);
}
