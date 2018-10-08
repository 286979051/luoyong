package com.zd.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import com.zd.entity.Salary_standard;
import com.zd.entity.Salary_standard_details;
import com.zd.entity.zm_some;
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
	
	//�����˲�ѯ������Ϣ
	public Salary_standard selone_Salary_standard(int ssd_id);
	
	//�����˲�ѯ������Ϣ--��Ŀ��Ϣ
	public List<zm_some> selone_zmsome(String standard_id);
	
	//��ѯ����
	public List<Salary_standard_details> selSalaryall();
	
	//��ѯ����
	public Salary_standard_details selSalaryone(String id);
}
