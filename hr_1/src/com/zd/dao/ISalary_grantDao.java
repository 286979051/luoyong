package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * н�귢�ŵǼǱ�
 * @author Administrator
 *
 */
public interface ISalary_grantDao {

	
	
	//��һ���������֣��ܽ�����
	@Select("SELECT first_kind_name fname,SUM(salary_sum) fsum,COUNT(first_kind_name) fcount FROM human_file GROUP BY first_kind_name")
	@ResultMap("mapMapper")
	public List<Map> selFist();
	//������������֣��ܽ�����
	@Select("SELECT second_kind_name sname,SUM(salary_sum) ssum,COUNT(second_kind_name) scount FROM human_file GROUP BY second_kind_name")
	@ResultMap("mapMapper")
	public List<Map> selSecond();
	//�������������֣��ܽ�����
	@Select("SELECT third_kind_name tname,SUM(salary_sum) tsum,COUNT(third_kind_name) tcount FROM human_file GROUP BY third_kind_name")
	@ResultMap("mapMapper")
	public List<Map> selThird();
	
	
	//��н������
	@Select("SELECT COUNT(*) FROM (SELECT * FROM human_file GROUP BY first_kind_name) count")
	public int selFCount();
	//��н������
	@Select("SELECT COUNT(*) FROM (SELECT * FROM human_file GROUP BY second_kind_name) count")
	public int selSCount();
	//��н������
	@Select("SELECT COUNT(*) FROM (SELECT * FROM human_file GROUP BY third_kind_name) count")
	public int selTCount();
	
	
	//��������
	@Select("SELECT COUNT(*) FROM (SELECT * FROM human_file) aaa")
	public int selHuman();
	
	
	//�����н������(һ��)
	@Select("SELECT SUM(salary_sum) FROM human_file WHERE first_kind_name!=''")
	public String selFMoney();
	//�����н������(����)
	@Select("SELECT SUM(salary_sum) FROM human_file WHERE second_kind_name!=''")
	public String selSMoney();
	//�����н������(����)
	@Select("SELECT SUM(salary_sum) FROM human_file WHERE third_kind_name!=''")
	public String selTMoney();
	
	
	//��ʵ���ܶ�(һ��)
	@Select("SELECT SUM(paid_salary_sum) FROM human_file WHERE first_kind_name!=''")
	public String selFShiMoney();
	//��ʵ���ܶ�(����)
	@Select("SELECT SUM(paid_salary_sum) FROM human_file WHERE second_kind_name!=''")
	public String selSShiMoney();
	//��ʵ���ܶ�(����)
	@Select("SELECT SUM(paid_salary_sum) FROM human_file WHERE third_kind_name!=''")
	public String selTShiMoney();
}
