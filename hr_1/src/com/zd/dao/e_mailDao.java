package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.e_mail;

public interface e_mailDao {
	//��ѯ���е����ʼ�ģ��
	@Select("select * from e_mail")
	@ResultMap("e_mailmapper")
	public List<e_mail> selalle_mail();
	//ɾ�������ʼ�ģ��
	@Delete("delete from e_mail where e_id=#{e_id}")
	public void delete_mail(int e_id);
	//��ӵ����ʼ�ģ��
	@Insert("insert into e_mail values(null,#{e_title},#{e_content},#{e_type})")
	public void adde_mail(e_mail email);
}
