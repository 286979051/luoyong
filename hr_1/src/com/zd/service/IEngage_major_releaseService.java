package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Engage_major_release;

public interface IEngage_major_releaseService {

	//职位发表登记表查询
	public List<Engage_major_release> releaseQuery();
	
	
	//职位发表登记表查询单条
	public Engage_major_release releaseQueryById(int id);
	
	//职位发表登记表修改
	public void releaseUpd(Engage_major_release Engage_major_release);
}
