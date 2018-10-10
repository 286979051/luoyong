package com.zd.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
	
	//�Ը�����Ϣ�����޸�
	public void updfuhe(Salary_standard salary_standard);
	
	//�Ը�����Ϣ�����޸�_2
	public void updfuhe2(Map map);
	
	//�Ը�����Ϣ�������
	public void addfuhe(Map map);
	
	//н���׼��ѯ����ģ����ѯ
	public List<Salary_standard> selstatus1(Map map);
	
	//н���׼��ѯ����ģ����ѯ������
	public int selcount(Map map);
	
	//���ݱ�Ų�ѯ������ѯн���׼
	public Salary_standard selbyid(String standard_id);
	
	//н���׼��ѯ�������ģ����ѯ 
	public List<Salary_standard> selstatus2(Map map);
	
	//�Ա����Ϣ�����޸�_1
	public void updbiangeng(Salary_standard salary_standard);
	//��ѯ����
	public List<Salary_standard_details> selSalaryall();
	//��ѯ����
	public Salary_standard_details selSalaryone(String id);
}
