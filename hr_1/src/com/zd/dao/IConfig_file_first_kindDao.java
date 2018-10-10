package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Config_file_first_kind;

public interface IConfig_file_first_kindDao {

	//һ����������
	@Select("select * from Config_file_first_kind")
	@ResultMap("Config_file_first_kindmapper")
	public List<Config_file_first_kind> query();
	//���һ������
	@Insert("insert into Config_file_first_kind values(null,#{firstkindid},#{firstkindname},#{firstkindsalaryid},#{firstkindsaleid})")
	public void add(Config_file_first_kind firstkind);
	//�޸�֮ǰ����ѯ
	@Select("select * from Config_file_first_kind where ffk_id=#{ffkid}")
	@ResultMap("Config_file_first_kindmapper")
	public Config_file_first_kind selbyffkid(int ffkid);
	//���ʱ��ѯһ����������
	@Select("select * from Config_file_first_kind where first_kind_id=#{firstkindid}")
	@ResultMap("Config_file_first_kindmapper")
	public Config_file_first_kind selbybhid(String firstkindid);
	//�޸�
	@Update("update Config_file_first_kind set first_kind_salary_id=#{firstkindsalaryid},first_kind_sale_id=#{firstkindsaleid} where ffk_id=#{ffkid}")
	public void update(Config_file_first_kind firstkind);
	//ɾ��һ������
	@Delete("delete from Config_file_first_kind where first_kind_id=#{firstkindid}")
	public void delete(String firstkindid);
	//ɾ��һ��������ͬʱɾ����������
	@Delete("delete from Config_file_second_kind where first_kind_id=#{firstkindid}")
	public void delete2(String firstkindid);
	//ɾ��һ��������ͬʱɾ�����������Լ���������
	@Delete("delete from Config_file_third_kind where first_kind_id=#{firstkindid}")
	public void delete3(String firstkindid);
	//һ����������������ѯ
	@Select("select * from Config_file_first_kind where first_kind_id=#{first_kind_id}")
	@ResultMap("Config_file_first_kindmapper")
	public Config_file_first_kind queryDan(String first_kind_id);
}
