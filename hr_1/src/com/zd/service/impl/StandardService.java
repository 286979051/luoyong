package com.zd.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IStandardDao;
import com.zd.entity.Salary_standard;
import com.zd.service.IStandardService;
/**
 * 
 * @author ����
 *
 */
@Service
public class StandardService implements IStandardService{
	@Autowired
	private IStandardDao dao;

	//���н�������Ϣ
	public void addstandard(Salary_standard salary_standard) {
		dao.addstandard(salary_standard);
	}

	// ���н����Ŀ��Ϣ
	public void addzm_some(Map map) {
		dao.addzm_some(map);
		
	}
}

