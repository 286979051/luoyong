package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Engage_major_release;

public interface IEngage_major_releaseService {

	//ְλ�����ǼǱ���ѯ
	public List<Engage_major_release> releaseQuery();
	
	
	//ְλ�����ǼǱ���ѯ����
	public Engage_major_release releaseQueryById(int id);
	
	//ְλ�����ǼǱ��޸�
	public void releaseUpd(Engage_major_release Engage_major_release);
	
	//ְλ�����Ǽ�ɾ��
	public void releaseDelete(int mid);
	
	//ְλ�����Ǽ�����
	public void releaseInsert(Engage_major_release Engage_major_release);
}