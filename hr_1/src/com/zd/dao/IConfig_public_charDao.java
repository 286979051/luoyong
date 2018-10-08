package com.zd.dao;

import java.util.List;

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
	
	//��ѯ��Ƹ���͵���
	@Select("SELECT * FROM Config_public_char where pbc_id=#{id}")
	@ResultMap("queryall")
	public Config_public_char QueryEngageTypeDan(int id);
	
	//�Ը�����Ϣ���в�ѯ���_zm
	@Select("SELECT attribute_name FROM config_public_char WHERE  pbc_id = #{pbc_id}")
	@ResultMap("queryall")
	public Config_public_char selfuhe(int pbc_id);
}
