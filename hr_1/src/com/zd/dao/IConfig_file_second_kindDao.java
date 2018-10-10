package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	@Insert("insert into Config_file_second_kind values(null,#{firstkindid},#{firstkindname},#{secondkindid},#{secondkindname},#{secondsalaryid},#{secondsaleid})")
	public void addsecond(Config_file_second_kind secondkind);
	//������������
	@Select("select * from Config_file_second_kind where second_kind_id=#{id}")
	@ResultMap("Config_file_second_kindmapper")
	public Config_file_second_kind queryDan(String id);
	
	//�޸Ķ�������ǰ����ѯ
	@Select("select * from Config_file_second_kind where fsk_id=#{fskid}")
	@ResultMap("Config_file_second_kindmapper")
	public Config_file_second_kind selbyfskid(int fskid);
	
	//�޸Ķ�������
	@Update("update Config_file_second_kind set second_salary_id=#{secondsalaryid},second_sale_id=#{secondsaleid} where fsk_id=#{fskid}")
	public void updatesecondkind(Config_file_second_kind secondkind);
	
	//ɾ����������
	@Delete("delete from Config_file_second_kind where second_kind_id=#{secondkindid}")
	public void deletesecond(String secondkindid);
	
	//ɾ������������ͬʱɾ����������
	@Delete("delete from Config_file_third_kind where second_kind_id=#{secondkindid}")
	public void delete2(String secondkindid);
	
	//����secondkindid��ѯ����(������ѯ,�����������)
	@Select("select * from Config_file_second_kind where second_kind_id=#{secondkindid}")
	@ResultMap("Config_file_second_kindmapper")
	public  Config_file_second_kind selbysecondkindid(String secondkindid);
	
	
}
