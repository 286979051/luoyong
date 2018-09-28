package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;

public interface IConfig_file_second_kindDao {

	
	//��������
	@Select("select * from Config_file_second_kind where first_kind_id=#{id}")
	@ResultMap("Config_file_second_kindmapper")
	public List<Config_file_second_kind> queryById(String id);
	
	//��ѯ���ж�������
	@Select("select * from Config_file_second_kind")
	@ResultMap("Config_file_second_kindmapper")
	public List<Config_file_second_kind> selall();
	
	//���֮ǰ��ѯ����һ����������
	@Select("select * from config_file_first_kind")
	@ResultMap("Config_file_first_kindmapper")
	public List<Config_file_first_kind> selallfirstname();
	
	//��Ӷ�������
	@Insert("insert into Config_file_second_kind values(null,#{first_kind_id},#{first_kind_name},#{second_kind_id},#{second_kind_name},#{second_salary_id},#{second_sale_id})")
	public void addsecond(Config_file_second_kind secondkind);
	//������������
	@Select("select * from Config_file_second_kind where second_kind_id=#{id}")
	@ResultMap("Config_file_second_kindmapper")
	public Config_file_second_kind queryDan(String id);
}
