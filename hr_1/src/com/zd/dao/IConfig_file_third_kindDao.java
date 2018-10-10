package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;

public interface IConfig_file_third_kindDao {

	//��������
	@Select("select * from Config_file_third_kind where second_kind_id=#{id}")
	@ResultMap("Config_file_third_kindmapper")
	public List<Config_file_third_kind> queryById(String id);
	//������������
	@Select("select * from Config_file_third_kind where third_kind_id=#{id}")
	@ResultMap("Config_file_third_kindmapper")
	public Config_file_third_kind queryDan(String id);
	
	//��ѯ������������
	@Select("select * from Config_file_third_kind")
	@ResultMap("Config_file_third_kindmapper")
	public List<Config_file_third_kind> selallthirdkind();
	//���ǰ��ѯһ������
	@Select("select * from Config_file_first_kind")
	@ResultMap("Config_file_first_kindmapper")
	public List<Config_file_first_kind> selallfirst();
	//���֮ǰ��ѯ���еĶ�������
	@Select("select * from Config_file_second_kind")
	@ResultMap("Config_file_second_kindmapper")
	public List<Config_file_second_kind> selallsecond();
	//�����������
	@Insert("insert into Config_file_third_kind values(null,#{firstkindid},#{firstkindname},#{secondkindid},#{secondkindname},#{thirdkindid},#{thirdkindname},#{thirdkindsaleid},#{thirdkindisretail})")
	public void addthirdkind(Config_file_third_kind thirdkind);
	//�޸�֮ǰ��ѯ
	@Select("select * from Config_file_third_kind where ftk_id=#{ftkid}")
	@ResultMap("Config_file_third_kindmapper")
	public Config_file_third_kind selthirdupdate(int ftkid);
	//�޸���������
	@Update("update Config_file_third_kind set third_kind_sale_id=#{thirdkindsaleid},third_kind_is_retail=#{thirdkindisretail} where ftk_id=#{ftkid}")
	public void updatethird(Config_file_third_kind thirdkind);
	//ɾ����������
	@Delete("delete from Config_file_third_kind where ftk_id=#{ftkid}")
	public void deletethird(int ftkid);
	
}
