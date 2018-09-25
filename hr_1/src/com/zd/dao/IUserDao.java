package com.zd.dao;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.user;

public interface IUserDao {
	//µÇÂ¼
	@Select("select * from user where user_name=#{user_name} and user_password=#{user_password}")
	@ResultMap("usermapper")
	public user login(user u);
}
