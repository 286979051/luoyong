package com.zd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_public_char;
/**
 * �������Dao��
 * @author Administrator
 *
 */
public interface IConfig_public_charDao {
	//��ѯ��������
	@Select("SELECT * FROM Config_public_char")
	@ResultMap("queryall")
	public List<Config_public_char> queryall();
	
	//zhangmin�Ĳ�ѯн�������еĹ����ֶ�
	@Select("SELECT * FROM config_public_char where attribute_kind = 'н������'")
	@ResultMap("queryall")
	public List<Config_public_char> selsalary();
	
	//zhangmin�Ĳ�ѯн�������еĹ����ֶ�(һ��һ)
	public List<Config_public_char> selzm_some(int pbc_id);
	
	//��ѯ��Ƹ����
	@Select("SELECT * FROM Config_public_char where attribute_kind='��Ƹ����'")
	@ResultMap("queryall")
	public List<Config_public_char> QueryEngageType();
	
	//��ѯ����
	@Select("SELECT * FROM Config_public_char where attribute_kind='����'")
	@ResultMap("queryall")
	public List<Config_public_char> QueryEngageGuoJi();
	
	//��ѯ����
	@Select("SELECT * FROM Config_public_char where attribute_kind='����'")
	@ResultMap("queryall")
	public List<Config_public_char> QueryEngageMinZu();
	
	//��ѯ�ڽ�����
	@Select("SELECT * FROM Config_public_char where attribute_kind='�ڽ�����'")
	@ResultMap("queryall")
	public List<Config_public_char> QueryEngageZongJiao();
	
	//��ѯ������ò
	@Select("SELECT * FROM Config_public_char where attribute_kind='������ò'")
	@ResultMap("queryall")
	public List<Config_public_char> QueryEngageMianMiao();
	
	//��ѯ��Ƹ���͵���
	@Select("SELECT * FROM Config_public_char where pbc_id=#{id}")
	@ResultMap("queryall")
	public Config_public_char QueryEngageTypeDan(int id);
	
	//�����У���ѯ����ְ��
	@Select("select * from Config_public_char where attribute_kind='ְ��'")
	@ResultMap("queryall")
	public List<Config_public_char> selprofessiondesign();
	//�����У�ɾ��ְ��
	@Delete("delete from Config_public_char where pbc_id=#{pbc_id}")
	public void deleteprofession(int pbc_id);
	//�����У���ѯ���й�������
	@Select("select * from Config_public_char")
	@ResultMap("queryall")
	public List<Config_public_char> selallpublicchar();
	//�����У�ɾ����������
	@Delete("delete from Config_public_char where pbc_id=#{pbc_id}")
	public void deletepublicchar(int pbc_id);
	//�����У���ӹ�������
	@Insert("insert into Config_public_char values(null,#{attribute_kind},#{attribute_name})")
	public void addConfigpublicchar(Config_public_char publicchar);
	//�����У���ѯ���е�н������
	@Select("select * from Config_public_char where attribute_kind='н������'")
	@ResultMap("queryall")
	public List<Config_public_char> salaryitemlist();
	//�����У�ɾ��н������
	@Delete("delete from Config_public_char where pbc_id=#{pbc_id}")
	public void deletesalaryitem(int pbc_id);
	//�����У����н������
	@Insert("insert into Config_public_char values(null,'н������',#{attribute_name})")
	public void addsalaryitem(Config_public_char publicchar);
}
