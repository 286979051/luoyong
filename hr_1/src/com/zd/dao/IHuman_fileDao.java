package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Config_shang;
import com.zd.entity.Human_file;

/**
 * 人员档案的添加与上传
 * @author Administrator
 *
 */
public interface IHuman_fileDao {

	//添加
	@Insert("insert into human_file values(null,#{human_id},#{first_kind_id},#{first_kind_name},#{second_kind_id},#{second_kind_name},#{third_kind_id},#{third_kind_name},"
			+ "#{human_name},#{human_address},#{human_postcode},#{human_pro_designation},"
			+ "#{human_major_kind_id},#{human_major_kind_name},#{human_major_id},#{hunma_major_name},"
			+ "#{human_telephone},#{human_mobilephone},#{human_bank},#{human_account},#{human_qq},#{human_email},#{human_hobby},"
			+ "#{human_speciality},#{human_sex},#{human_religion},#{human_party},#{human_nationality},#{human_race},"
			+ "#{human_birthday},#{human_birthplace},#{human_age},#{human_educated_degree},#{human_educated_years},#{human_educated_major},"
			+ "#{human_society_security_id},#{human_id_card},#{remark},#{salary_standard_id},#{salary_standard_name},"
			+ "#{salary_sum},#{demand_salaray_sum},null,null,null,null,null,#{human_histroy_records},#{human_family_membership},null,null,2,#{register},null,null,"
			+ "#{regist_time},null,null,null,null,null,1)")
		public void add(Human_file humman_file);
	
	//查询为二的
	@Select("select * from human_file where check_status = 2")
	@ResultMap("Humanfil")
	public List<Human_file> Humanfileselall();
	
	//查询所有
	@Select("select * from human_file")
	@ResultMap("Humanfil")
	public List<Human_file> Humanfileallsel();
		
	//根据档案号查询
	@Select("select * from human_file where human_id = #{human_id}")
	@ResultMap("Humanfil")
	public Human_file Humanfileidselall(String human_id);
	
	@Update("update human_file SET human_picture =#{attribute_name} where human_id = #{pbc_id}")
	public void update(Config_shang shang);
	
	//修改
	@Update("UPDATE human_file SET human_name=#{human_name},human_address=#{human_address},human_postcode=#{human_postcode},human_pro_designation=#{human_pro_designation},human_telephone=#{human_telephone},"
			+ "human_mobilephone=#{human_mobilephone},human_bank=#{human_bank},human_account=#{human_account},human_qq=#{human_qq},human_email=#{human_email},human_hobby=#{human_hobby},human_speciality=#{human_speciality},"
			+ "human_sex=#{human_sex},human_religion=#{human_religion},human_party=#{human_party},human_nationality=#{human_nationality},human_race=#{human_race},human_birthday=#{human_birthday},human_birthplace=#{human_birthplace},"
			+ "human_age=#{human_age},human_educated_degree=#{human_educated_degree},human_educated_years=#{human_educated_years},human_educated_major=#{human_educated_major},human_society_security_id=#{human_society_security_id},"
			+ "human_id_card=#{human_id_card},remark=#{remark},salary_standard_id=#{salary_standard_id},salary_standard_name=#{salary_standard_name},salary_sum=#{salary_sum},demand_salaray_sum=#{demand_salaray_sum},"
			+ "human_histroy_records=#{human_histroy_records},human_family_membership=#{human_family_membership},check_status=1,checker=#{checker},check_time=#{check_time},human_file_status=2 WHERE human_id = #{human_id}")
	public void human_chack_update(Human_file humman_file);

	//多条件查询
	//@Select("select * from Human_file where first_kind_id=#{first_kind_id} and second_kind_id = #{second_kind_id} AND third_kind_id = #{third_kind_id} and human_major_kind_id = #{human_major_kind_id} and human_major_id = #{human_major_id} and regist_time BETWEEN  #{startDate} and #{endDate}")
	//@ResultMap("Humanfil")
	public List<Human_file> query_list(Map map);
	
	//修改变更
		@Update("UPDATE human_file SET human_name=#{human_name},human_address=#{human_address},human_postcode=#{human_postcode},human_pro_designation=#{human_pro_designation},human_telephone=#{human_telephone},"
				+ "human_mobilephone=#{human_mobilephone},human_bank=#{human_bank},human_account=#{human_account},human_qq=#{human_qq},human_email=#{human_email},human_hobby=#{human_hobby},human_speciality=#{human_speciality},"
				+ "human_sex=#{human_sex},human_religion=#{human_religion},human_party=#{human_party},human_nationality=#{human_nationality},human_race=#{human_race},human_birthday=#{human_birthday},human_birthplace=#{human_birthplace},"
				+ "human_age=#{human_age},human_educated_degree=#{human_educated_degree},human_educated_years=#{human_educated_years},human_educated_major=#{human_educated_major},human_society_security_id=#{human_society_security_id},"
				+ "human_id_card=#{human_id_card},remark=#{remark},salary_standard_id=#{salary_standard_id},salary_standard_name=#{salary_standard_name},salary_sum=#{salary_sum},demand_salaray_sum=#{demand_salaray_sum},"
				+ "human_histroy_records=#{human_histroy_records},human_family_membership=#{human_family_membership},check_status=2,checker=#{checker},check_time=#{check_time},human_file_status=1 WHERE human_id = #{human_id}")
		public void human_chack_upd(Human_file humman_file);
		
	//删除条件查询
	public List<Human_file> delete_list(Map map);
	
	//修改
	@Update("UPDATE human_file SET human_file_status=3 WHERE human_id = #{human_id}")
	public void delete_update(String human_id);
	
	//删除恢复查询
	public List<Human_file> recovery_list(Map map);
	
	//修改
	@Update("UPDATE human_file SET human_file_status=2 WHERE human_id = #{human_id}")
	public void recovery_update(String human_id);
	
	//查询要删除的人员
	@Select("select * from Human_file where human_file_status=3")
	@ResultMap("Humanfil")
	public List<Human_file> deletequery();
	
	//永久删除
	@Delete("delete FROM Human_file where human_id = #{id}")
	public void deletey(String id);
}
