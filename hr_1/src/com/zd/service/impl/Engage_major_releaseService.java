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
	
	//ְλ����ǼǱ��ѯ
	public List<Engage_major_release> releaseQuery() {
		return engage_major_releaseDao.releaseQuery();
	}

	//ְλ����ǼǱ��ѯ����
	public Engage_major_release releaseQueryById(int id) {
		return engage_major_releaseDao.releaseQueryById(id);
	}

	
	//ְλ����ǼǱ��޸�
	public void releaseUpd(Engage_major_release Engage_major_release) {
		engage_major_releaseDao.releaseUpd(Engage_major_release);
		
	}

}
