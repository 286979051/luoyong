package com.zd.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zd.entity.Salary_standard;
/**
 * 
 * @author ����
 *
 */
@Service
public interface IStandardService {
	
	public void addstandard(Salary_standard salary_standard);
	
	public void addzm_some(Map map);
	
	//н���׼�ǼǸ��˷�ҳ��ѯ��Ϣ����
	public int selallSalary_count();
	
	//н���׼�ǼǸ��˷�ҳ��ѯ
	public List<Salary_standard> selallSalary(int start);
}
