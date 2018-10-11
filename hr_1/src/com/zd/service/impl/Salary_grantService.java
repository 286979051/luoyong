package com.zd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.ISalary_grantDao;
import com.zd.entity.Config_file_first_kind;
import com.zd.entity.Config_file_second_kind;
import com.zd.entity.Config_file_third_kind;
import com.zd.entity.Config_public_char;
import com.zd.entity.Human_file;
import com.zd.entity.Salary_grant;
import com.zd.entity.Salary_grant_details;
import com.zd.entity.Salary_standard_details;
import com.zd.entity.zm_some;
import com.zd.service.ISalary_grantService;

@Service
public class Salary_grantService implements ISalary_grantService {

	@Autowired
	private ISalary_grantDao salary_grantDao;

	
	//��һ���������֣��ܽ�����
	public List<Map> selFirst() {
		return salary_grantDao.selFirst();
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
	
	
	//��һ������������
	public int selFHuman() {
		return salary_grantDao.selFHuman();
	}
	//���������������
	public int selSHuman() {
		return salary_grantDao.selSHuman();
	}
	//����������������
	public int selTHuman() {
		return salary_grantDao.selTHuman();
	}
	
	
	//�����н������(һ��)
	public String selFMoney() {
		return salary_grantDao.selFMoney();
	}
	//�����н������(����)
	public String selSMoney() {
		return salary_grantDao.selSMoney();
	}
	//�����н������(����)
	public String selTMoney() {
		return salary_grantDao.selTMoney();
	}
	
	
	//��ʵ���ܶ�(һ��)
	public String selFShiMoney() {
		return salary_grantDao.selFShiMoney();
	}
	//��ʵ���ܶ�(����)
	public String selSShiMoney() {
		return salary_grantDao.selSShiMoney();
	}
	//��ʵ���ܶ�(����)
	public String selTShiMoney() {
		return salary_grantDao.selTShiMoney();
	}
	
	
	
	//��һ������ź�����
	public List<Human_file> queryFHuman(String first_kind_name){
		return salary_grantDao.queryFHuman(first_kind_name);
	}
	//���������ź�����
	public List<Human_file> querySHuman(String second_kind_name){
		return salary_grantDao.querySHuman(second_kind_name);
	}
	//����������ź�����
	public List<Human_file> queryTHuman(String third_kind_name){
		return salary_grantDao.queryTHuman(third_kind_name);
	}
	
	
	//��һ������������
	public int queryFBCount(String first_kind_name) {
		return salary_grantDao.queryFBCount(first_kind_name);
	}
	//���������������
	public int querySBCount(String second_kind_name) {
		return salary_grantDao.querySBCount(second_kind_name);
	}
	//����������������
	public int queryTBCount(String third_kind_name) {
		return salary_grantDao.queryTBCount(third_kind_name);
	}
	
	
	//�����н������
	public String selsum(String first_kind_name) {
		return salary_grantDao.selsum(first_kind_name);
	}

	//����Ŀ����
	public List<Config_public_char> selItem(){
		return salary_grantDao.selItem();
	}
	
	
	//��н���׼����ϸ��Ϣ
	public List<Salary_standard_details> queryssd(String ssd){
		return salary_grantDao.queryssd(ssd);
	}
	
	
	//��һ��������
	public Config_file_first_kind selF(String first_kind_name){
		return salary_grantDao.selF(first_kind_name);
	}
	//�����������
	public Config_file_second_kind selS(String second_kind_name){
		return salary_grantDao.selS(second_kind_name);
	}
	//������������
	public Config_file_third_kind selT(String third_kind_name){
		return salary_grantDao.selT(third_kind_name);
	}
	
	
	//���н�귢����ϸ��Ϣ
	public void addDetails(Salary_grant_details sgd) {
		salary_grantDao.addDetails(sgd);
	}
	//���н�귢�ŵǼǱ�
	public void addgrant(Salary_grant sgt) {
		salary_grantDao.addgrant(sgt);
	}
	
	
	//��н�귢�ŵǼǱ�
	public List<Salary_grant> selAll(){
		return salary_grantDao.selAll();
	}
	
	
	
}
