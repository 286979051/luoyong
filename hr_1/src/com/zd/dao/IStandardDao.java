package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Salary_standard;
/**
 * н���׼���ƶ�����
 * @author ����
 *
 */
import com.zd.entity.zm_some;
public interface IStandardDao {

	//���н��Ļ�����Ϣ
	@Insert("INSERT INTO salary_standard VALUES(NULL,#{standard_id},#{standard_name},#{designer},#{register},NULL,NULL,#{regist_time},NULL,NULL,#{salary_sum},2,0,NULL,#{remark})")
	public void addstandard(Salary_standard salary_standard);
	
	//���н����Ŀ
	@Insert("INSERT INTO zm_some VALUES(#{standard_id},#{pbc_id},#{money})")
	public void addzm_some(Map map);
	
	//н���׼�ǼǸ��˷�ҳ��ѯ
	public List<Salary_standard> selallSalary(int start);
	
	//н���׼�ǼǸ��˷�ҳ��ѯ��Ϣ����
	@Select("SELECT COUNT(*) FROM salary_standard")
	public int selallSalary_count();	
	
	//�����˲�ѯ������Ϣ--������Ϣ
	@Select("SELECT * FROM salary_standard WHERE  ssd_id = #{ssd_id}")
	@ResultMap("salary_standardMapper")
	public Salary_standard selone_Salary_standard(int ssd_id);
	
	//�����˲�ѯ������Ϣ--��Ŀ��Ϣ
	public List<zm_some> selone_zmsome(String standard_id);

}
