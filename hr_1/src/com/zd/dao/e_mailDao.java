package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.e_mail;

public interface e_mailDao {
	//查询所有电子邮件模板
	@Select("select * from e_mail")
	@ResultMap("e_mailmapper")
	public List<e_mail> selalle_mail();
	//删除电子邮件模板
	@Delete("delete from e_mail where e_id=#{e_id}")
	public void delete_mail(int e_id);
	//添加电子邮件模板
	@Insert("insert into e_mail values(null,#{e_title},#{e_content},#{e_type})")
	public void adde_mail(e_mail email);
}
