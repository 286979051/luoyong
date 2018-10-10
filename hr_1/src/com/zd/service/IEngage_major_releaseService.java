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
	
	//职位发表登记删除
	public void releaseDelete(int mid);
	
	//职位发表登记添加
	public void releaseInsert1(Engage_major_release Engage_major_release);
	
	//职位发表登记添加
	public void releaseInsert2(Engage_major_release Engage_major_release);
		
		//职位发表登记添加
	public void releaseInsert3(Engage_major_release Engage_major_release);
	
	//职位发表登记表申请修改
	public void releaseUpdShenQ(Engage_major_release Engage_major_release);
}
