package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IEngage_major_releaseDao;
import com.zd.entity.Engage_major_release;
import com.zd.service.IEngage_major_releaseService;

@Service
public class Engage_major_releaseService implements IEngage_major_releaseService{

	@Autowired
	private IEngage_major_releaseDao engage_major_releaseDao;
	
	//职位发表登记表查询
	public List<Engage_major_release> releaseQuery() {
		return engage_major_releaseDao.releaseQuery();
	}

	//职位发表登记表查询单条
	public Engage_major_release releaseQueryById(int id) {
		return engage_major_releaseDao.releaseQueryById(id);
	}

	
	//职位发表登记表修改
	public void releaseUpd(Engage_major_release Engage_major_release) {
		engage_major_releaseDao.releaseUpd(Engage_major_release);
		
	}

	//职位发表登记删除
	public void releaseDelete(int mid) {
		engage_major_releaseDao.releaseDelete(mid);
	}

	//职位发表登记添加
	public void releaseInsert1(Engage_major_release Engage_major_release) {
		engage_major_releaseDao.releaseInsert1(Engage_major_release);
	}
	
	//职位发表登记添加
	public void releaseInsert2(Engage_major_release Engage_major_release) {
		engage_major_releaseDao.releaseInsert2(Engage_major_release);
	}
		
	//职位发表登记添加
	public void releaseInsert3(Engage_major_release Engage_major_release) {
		engage_major_releaseDao.releaseInsert3(Engage_major_release);
	}

	//职位发表登记表申请修改
	public void releaseUpdShenQ(Engage_major_release Engage_major_release) {
		engage_major_releaseDao.releaseUpdShenQ(Engage_major_release);
	}

}
