package com.zd.dao;

import org.apache.ibatis.annotations.Insert;

import com.zd.entity.Config_shang;

public interface IConfig_shangDao {

	//xts��ӹ�������ֶ�
	@Insert("INSERT INTO Config_shang VALUES(#{pbc_id},#{attribute_kind},#{attribute_name})")
	public void add(Config_shang shang);
}
