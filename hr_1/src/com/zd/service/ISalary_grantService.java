package com.zd.service;

import java.util.List;
import java.util.Map;

import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Human_file;
import com.zd.entity.Salary_grant;
import com.zd.entity.Salary_grant_details;
import com.zd.entity.Salary_standard_details;
import com.zd.entity.zm_some;



public interface ISalary_grantService {

	
	
	//��һ���������֣��ܽ�����
	public List<Map> selFirst();
	//������������֣��ܽ�����
	public List<Map> selSecond();
	//�������������֣��ܽ�����
	public List<Map> selThird();
	
	
	//��н������
	public int selFCount();
	//��н������
	public int selSCount();
	//��н������
	public int selTCount();
	
	
	//��һ������������
	public int selFHuman();
	//���������������
	public int selSHuman();
	//����������������
	public int selTHuman();
	
	
	//�����н������(һ��)
	public String selFMoney();
	//�����н������(����)
	public String selSMoney();
	//�����н������(����)
	public String selTMoney();
	
	
	//��ʵ���ܶ�(һ��)
	public String selFShiMoney();
	//��ʵ���ܶ�(����)
	public String selSShiMoney();
	//��ʵ���ܶ�(����)
	public String selTShiMoney();
	
	
	
	//��һ������ź�����
	public List<Human_file> queryFHuman(String first_kind_name);
	//���������ź�����
	public List<Human_file> querySHuman(String second_kind_name);
	//����������ź�����
	public List<Human_file> queryTHuman(String third_kind_name);
	
	
	//��һ������������
	public int queryFBCount(String first_kind_name);
	//���������������
	public int querySBCount(String second_kind_name);
	//����������������
	public int queryTBCount(String third_kind_name);
	
	//�����н������
	public String selsum(String first_kind_name);
	
	
	//����Ŀ����
	public List<Config_public_char> selItem();
	
	//��н���׼����ϸ��Ϣ
	public List<Salary_standard_details> queryssd(String ssd);
	
	
	//��һ��������
	public Config_file_first_kind selF(String first_kind_name);
	//�����������
	public Config_file_second_kind selS(String second_kind_name);
	//������������
	public Config_file_third_kind selT(String third_kind_name);
	
	//���н�귢����ϸ��Ϣ
	public void addDetails(Salary_grant_details sgd);
	
	//���н�귢�ŵǼǱ�
	public void addgrant(Salary_grant sgt);
	
	
	//��н�귢�ŵǼǱ�
	public List<Salary_grant> selAll();
	
	
}
