package com.zd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zd.entity.Engage_major_release;

public interface IEngage_major_releaseDao {

	//ְλ����ǼǱ��ѯ
	@Select("select * from Engage_major_release")
	@ResultMap("Engage_major_releasemapper")
	public List<Engage_major_release> releaseQuery();
	 
	//ְλ����ǼǱ��ѯ����
	@Select("select * from Engage_major_release where mre_id=#{id}")
	@ResultMap("engage_major_releasemapper")
	public Engage_major_release releaseQueryById(int id);
	
	//ְλ����ǼǱ��޸�
	@Update("update Engage_major_release set human_amount=#{human_amount},deadline=#{deadline},changer=#{changer},major_describe=#{major_describe},engage_required=#{engage_required} where mre_id=#{mre_id}")
	public void releaseUpd(Engage_major_release Engage_major_release);
	
}
