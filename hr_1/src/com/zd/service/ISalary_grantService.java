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
	public double selFMoney();
	//�����н������(����)
	public double selSMoney();
	//�����н������(����)
	public double selTMoney();
	
	
	//��ʵ���ܶ�(һ��)
	public double selFShiMoney();
	//��ʵ���ܶ�(����)
	public double selSShiMoney();
	//��ʵ���ܶ�(����)
	public double selTShiMoney();
}
