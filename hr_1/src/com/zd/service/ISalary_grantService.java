package com.zd.service;

import java.util.List;
import java.util.Map;



public interface ISalary_grantService {

	
	
	//��һ���������֣��ܽ�����
	public List<Map> selFist();
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
	
	
	//��������
	public int selHuman();
	
	
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
}
