package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Engage_resume;

public interface IEngage_resumeService {

	//¼òÀúµÇ¼Ç
	public void Engage_resume_Insert(Engage_resume Engage_resume);
	
	public List<Engage_resume> selresume(Map map);
	
	public Engage_resume Engage_resume_FUHE(int id);
	
	public void Engage_resume_Update(Engage_resume engage_resume);
}
