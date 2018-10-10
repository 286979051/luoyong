package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	@Select("SELECT COUNT(*) FROM salary_standard WHERE check_status = 2")
	public int selallSalary_count();	
	
	//�����˲�ѯ������Ϣ--������Ϣ
	@Select("SELECT * FROM salary_standard WHERE  ssd_id = #{ssd_id}")
	@ResultMap("salary_standardMapper")
	public Salary_standard selone_Salary_standard(int ssd_id);
	
	//�����˲�ѯ������Ϣ--��Ŀ��Ϣ
	public List<zm_some> selone_zmsome(String standard_id);

	//�Ը�����Ϣ�����޸�_1
	@Update("UPDATE salary_standard SET standard_name=#{standard_name},designer=#{designer},checker=#{checker},check_time=#{check_time},salary_sum=#{salary_sum},check_status=1,check_comment=#{check_comment} WHERE standard_id=#{standard_id};")
	public void updfuhe(Salary_standard salary_standard);
	
	//�Ը�����Ϣ�����޸�_2
	@Update("UPDATE zm_some  SET money = #{money} WHERE standard_id=#{standard_id} AND pbc_id = #{pbc_id}")
	public void updfuhe2(Map map);
	
	//�Ը�����Ϣ�������
	@Insert("INSERT INTO salary_standard_details VALUES(NULL,#{standard_id},#{standard_name},#{item_id},#{item_name},#{salary})")
	public void addfuhe(Map map);
	
	//н���׼��ѯ����ģ����ѯ
	public List<Salary_standard> selstatus1(Map map);
	
	//н���׼��ѯ����ģ����ѯ������
	public int selcount(Map map);
	
	//���ݱ�Ų�ѯ������ѯн���׼
	@Select("SELECT * FROM salary_standard WHERE standard_id = #{standard_id}")
	@ResultMap("salary_standardMapper")
	public Salary_standard selbyid(String standard_id);
	
	//н���׼��ѯ�������ģ����ѯ 
	public List<Salary_standard> selstatus2(Map map);
	
	//�Ա����Ϣ�����޸�_1
	@Update("UPDATE salary_standard SET standard_name=#{standard_name},designer=#{designer},changer=#{changer},change_time=#{change_time},salary_sum=#{salary_sum},remark=#{remark} WHERE standard_id=#{standard_id};")
	public void updbiangeng(Salary_standard salary_standard);
}
