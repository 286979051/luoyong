package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IEngage_resumeDao;
import com.zd.entity.Engage_resume;
import com.zd.service.IEngage_resumeService;

@Service
public class Engage_resumeService implements IEngage_resumeService{

	@Autowired
	private IEngage_resumeDao engage_resumeDao;
	
	//¼òÀúµÇ¼Ç
	public void Engage_resume_Insert(Engage_resume engage_resume) {
		engage_resumeDao.Engage_resume_Insert(engage_resume);
	}

	public List<Engage_resume> selresume(Map map) {
		return engage_resumeDao.selresume(map);
	}
	
	public Engage_resume Engage_resume_FUHE(int id) {
		return engage_resumeDao.Engage_resume_FUHE(id);
	}
	
	public void Engage_resume_Update(Engage_resume engage_resume) {
		engage_resumeDao.Engage_resume_Update( engage_resume);
	}
}
