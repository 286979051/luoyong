package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.ISalary_grantDao;
import com.zd.entity.Human_file;
import com.zd.entity.Salary_grant;
import com.zd.service.ISalary_grantService;

@Service
public class Salary_grantService implements ISalary_grantService {

	@Autowired
	private ISalary_grantDao salary_grantDao;

	
	//��һ���������֣��ܽ�����
	public List<Map> selFist() {
		return salary_grantDao.selFist();
	}
	//������������֣��ܽ�����
	public List<Map> selSecond(){
		return salary_grantDao.selSecond();
	}
	//�������������֣��ܽ�����
	public List<Map> selThird(){
		return salary_grantDao.selThird();
	}
	
	
	//��н������
	public int selFCount() {
		return salary_grantDao.selFCount();
	}
	//��н������
	public int selSCount() {
		return salary_grantDao.selSCount();
	}
	//��н������
	public int selTCount() {
		return salary_grantDao.selTCount();
	}
	
	
	//��������
	public int selHuman() {
		return salary_grantDao.selHuman();
	}
	
	
	//�����н������(һ��)
	public double selFMoney() {
		return salary_grantDao.selFMoney();
	}
	//�����н������(����)
	public double selSMoney() {
		return salary_grantDao.selSMoney();
	}
	//�����н������(����)
	public double selTMoney() {
		return salary_grantDao.selTMoney();
	}
	
	
	//��ʵ���ܶ�(һ��)
	public double selFShiMoney() {
		return salary_grantDao.selFShiMoney();
	}
	//��ʵ���ܶ�(����)
	public double selSShiMoney() {
		return salary_grantDao.selSShiMoney();
	}
	//��ʵ���ܶ�(����)
	public double selTShiMoney() {
		return salary_grantDao.selTShiMoney();
	}
}
