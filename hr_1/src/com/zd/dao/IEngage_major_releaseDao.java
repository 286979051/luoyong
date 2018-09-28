package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Engage_major_release;

public interface IEngage_major_releaseDao {

	//职位发表登记表查询
	@Select("select * from Engage_major_release")
	@ResultMap("Engage_major_releasemapper")
	public List<Engage_major_release> releaseQuery();
	 
	//职位发表登记表查询单条
	@Select("select * from Engage_major_release where mre_id=#{id}")
	@ResultMap("engage_major_releasemapper")
	public Engage_major_release releaseQueryById(int id);
	
	//职位发表登记表修改
	@Update("update Engage_major_release set engage_type=#{engage_type},human_amount=#{human_amount},deadline=#{deadline},changer=#{changer},major_describe=#{major_describe},engage_required=#{engage_required} where mre_id=#{mre_id}")
	public void releaseUpd(Engage_major_release Engage_major_release);
	
	//职位发表登记表申请修改
	@Update("update Engage_major_release set first_kind_id=#{first_kind_id},first_kind_name=#{first_kind_name},second_kind_id=#{second_kind_id},second_kind_name=#{second_kind_name},third_kind_id=#{third_kind_id},third_kind_name=#{third_kind_name},major_kind_id=#{major_kind_id},major_kind_name=#{major_kind_name},major_id=#{major_id},major_name=#{major_name},engage_type=#{engage_type},engage_type=#{engage_type},human_amount=#{human_amount},deadline=#{deadline},changer=#{changer},major_describe=#{major_describe},engage_required=#{engage_required} where mre_id=#{mre_id}")
	public void releaseUpdShenQ(Engage_major_release Engage_major_release);
	
	//职位发表登记删除
	@Delete("delete from Engage_major_release where mre_id=#{id}")
	public void releaseDelete(int mid);
	
	//职位发表登记添加
	@Insert("insert into Engage_major_release value(null,#{first_kind_id},#{first_kind_name},#{second_kind_id},#{second_kind_name},#{third_kind_id},#{third_kind_name},#{major_kind_id},#{major_kind_name},#{major_id},#{major_name},#{human_amount},#{engage_type},null,#{register},null,null,null,#{major_describe},#{engage_required})")                                                          
	public void releaseInsert(Engage_major_release Engage_major_release);
}
