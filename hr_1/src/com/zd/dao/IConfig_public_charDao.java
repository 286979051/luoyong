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
}
