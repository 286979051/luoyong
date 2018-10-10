package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IStandardDao;
import com.zd.entity.Salary_standard;
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

	//�Ը�����Ϣ�����޸�
	public void updfuhe(Salary_standard salary_standard) {
		dao.updfuhe(salary_standard);
	}
	
	//�Ը�����Ϣ�����޸�_2
	public void updfuhe2(Map map) {
		dao.updfuhe2(map);
	}

	//�Ը�����Ϣ�������
	public void addfuhe(Map map) {
		dao.addfuhe(map);
		
	}

	//н���׼��ѯ����ģ����ѯ
	public List<Salary_standard> selstatus1(Map map) {
		return dao.selstatus1(map);
	}

	//н���׼��ѯ����ģ����ѯ������
	public int selcount(Map map) {
		return dao.selcount(map);
	}

	//���ݱ�Ų�ѯ������ѯн���׼
	public Salary_standard selbyid(String standard_id) {
		return dao.selbyid(standard_id);
	}

	//н���׼��ѯ�������ģ����ѯ 
	public List<Salary_standard> selstatus2(Map map) {
		return dao.selstatus2(map);
	}

	//�Ա����Ϣ�����޸�_1
	public void updbiangeng(Salary_standard salary_standard) {
		dao.updbiangeng(salary_standard);
	}

	
	public List<com.zd.entity.Salary_standard_details> selSalaryall(){
		return dao.selSalaryall();
	}

	public com.zd.entity.Salary_standard_details selSalaryone(String id) {
		return dao.selSalaryone(id);
	}
}

