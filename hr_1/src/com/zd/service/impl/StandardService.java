package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IStandardDao;
import com.zd.entity.Salary_standard;
import com.zd.entity.Salary_standard_details;
import com.zd.entity.zm_some;
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

	//н���׼�ǼǸ��˷�ҳ��ѯ��Ϣ����
	public int selallSalary_count() {
		return dao.selallSalary_count();
	}

	//н���׼�ǼǸ��˷�ҳ��ѯ
	public List<Salary_standard> selallSalary(int start) {
		return dao.selallSalary(start);
	}
	
	//�����˲�ѯ������Ϣ
	public Salary_standard selone_Salary_standard(int ssd_id) {
		return dao.selone_Salary_standard(ssd_id);
	}

	//�����˲�ѯ������Ϣ--��Ŀ��Ϣ
	public List<zm_some> selone_zmsome(String standard_id) {
		return dao.selone_zmsome(standard_id);
	}

	public List<Salary_standard_details> selSalaryall(){
		return dao.selSalaryall();
	}

	public Salary_standard_details selSalaryone(String id) {
		return dao.selSalaryone(id);
	}
}

