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
	
	//张紫行，查询所有职称
	@Select("select * from Config_public_char where attribute_kind='职称'")
	@ResultMap("queryall")
	public List<Config_public_char> selprofessiondesign();
	//张紫行，删除职称
	@Delete("delete from Config_public_char where pbc_id=#{pbc_id}")
	public void deleteprofession(int pbc_id);
	//张紫行，查询所有公共属性
	@Select("select * from Config_public_char")
	@ResultMap("queryall")
	public List<Config_public_char> selallpublicchar();
	//张紫行，删除公共属性
	@Delete("delete from Config_public_char where pbc_id=#{pbc_id}")
	public void deletepublicchar(int pbc_id);
	//张紫行，添加公共属性
	@Insert("insert into Config_public_char values(null,#{attribute_kind},#{attribute_name})")
	public void addConfigpublicchar(Config_public_char publicchar);
	//张紫行，查询所有的薪酬设置
	@Select("select * from Config_public_char where attribute_kind='薪酬设置'")
	@ResultMap("queryall")
	public List<Config_public_char> salaryitemlist();
	//张紫行，删除薪酬设置
	@Delete("delete from Config_public_char where pbc_id=#{pbc_id}")
	public void deletesalaryitem(int pbc_id);
	//张紫行，添加薪酬设置
	@Insert("insert into Config_public_char values(null,'薪酬设置',#{attribute_name})")
	public void addsalaryitem(Config_public_char publicchar);
}
