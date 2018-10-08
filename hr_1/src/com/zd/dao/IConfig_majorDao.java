package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_major;
import com.zd.entity.Config_major_kind;

public interface IConfig_majorDao {

	//ְҵ����������� 
	@Select("select * from Config_major where major_kind_id=#{id}")
	@ResultMap("Config_majormapper")
	public List<Config_major> ErMajorQuery(String id);
	
	//ְҵ���������������
	@Select("select * from Config_major where major_id=#{id}")
	@ResultMap("Config_majormapper")
	public Config_major ErMajorQueryDan(int id);
	
	//�����У���ѯ����ְλ
	@Select("select * from Config_major")
	@ResultMap("Config_majormapper")
	public List<Config_major> selallConfig_major();
	
	//�����У�ɾ��ְλ
	@Delete("delete from Config_major where mak_id=#{makid}")
	public void deletemajor(int makid);
	
	//�����У����ְλ
	@Insert("insert into Config_major values(null,#{majorkindid},#{majorkindname},#{majorid},#{majorname})")
	public void addConfig_major(Config_major Configmajor);
	
	//�����У�����ְλ����id��ѯְλ����
	@Select("select * from Config_major_kind where major_kind_id=#{major_kind_id}")
	@ResultMap("Config_major_kindmapper")
	public Config_major_kind majorkindname(String majorkindid);
	public Config_major ErMajorQueryDan(String id);
}
