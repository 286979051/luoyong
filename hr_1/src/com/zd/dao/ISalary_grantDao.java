package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_public_char;
import com.zd.entity.Human_file;
import com.zd.entity.Salary_standard_details;
import com.zd.entity.zm_some;

/**
 * н�귢�ŵǼǱ�
 * @author Administrator
 *
 */
public interface ISalary_grantDao {

	
	
	//��һ���������֣��ܽ�����
	@Select("SELECT first_kind_name fname,SUM(salary_sum) fsum,COUNT(first_kind_name) fcount FROM human_file GROUP BY first_kind_name")
	@ResultMap("mapMapper")
	public List<Map> selFirst();
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
	
	
	//��һ������������
	@Select("SELECT COUNT(*) FROM human_file GROUP BY first_kind_name !=''")
	public int selFHuman();
	//���������������
	@Select("SELECT COUNT(*) FROM human_file GROUP BY second_kind_name !=''")
	public int selSHuman();
	//����������������
	@Select("SELECT COUNT(*) FROM human_file GROUP BY third_kind_name !=''")
	public int selTHuman();
	
	
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
	
	
	//��һ������ź�����
	@Select("SELECT human_id,human_name,salary_standard_id FROM human_file WHERE first_kind_name=#{first_kind_name} ")
	@ResultMap("humanMapper")
	public List<Human_file> queryFHuman(String first_kind_name);
	//���������ź�����
	@Select("SELECT human_id,human_name,salary_standard_id FROM human_file WHERE second_kind_name=#{second_kind_name} ")
	@ResultMap("humanMapper")
	public List<Human_file> querySHuman(String second_kind_name);
	//����������ź�����
	@Select("SELECT human_id,human_name,salary_standard_id FROM human_file WHERE third_kind_name=#{third_kind_name} ")
	@ResultMap("humanMapper")
	public List<Human_file> queryTHuman(String third_kind_name);
	
	
	//��һ������������
	@Select("SELECT COUNT(*) FROM human_file WHERE first_kind_name=#{first_kind_name}")
	public int queryFBCount(String first_kind_name);
	//���������������
	@Select("SELECT COUNT(*) FROM human_file WHERE second_kind_name=#{second_kind_name}")
	public int querySBCount(String second_kind_name);
	//���������������
	@Select("SELECT COUNT(*) FROM human_file WHERE third_kind_name=#{third_kind_name}")
	public int queryTBCount(String third_kind_name);
	

	//����Ŀ����
	@Select("SELECT * FROM config_public_char WHERE attribute_kind='н������'")
	public List<Config_public_char> selItem();
	
	//��н���׼����ϸ��Ϣ
	@Select("SELECT * FROM Salary_standard_details WHERE standard_id=#{ssd}")
	@ResultMap("salary_standard_detailsMapper")
	public List<Salary_standard_details> queryssd(String ssd);
	
//	//��ӵǼ�
//	@Insert("insert")
	
}
