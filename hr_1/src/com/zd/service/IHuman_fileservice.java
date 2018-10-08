package com.zd.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.zd.entity.Config_shang;
import com.zd.entity.Human_file;

public interface IHuman_fileservice {
	//添加
	public void add(Human_file humman_file);
	//查询为二的
	public List<Human_file> Humanfileselall();
	//修改图片
	public void update(Config_shang shang);
	//修改
	public void human_chack_update(Human_file humman_file);
	//多条件查询
	public List<Human_file> query_list(Map map);
	//根据档案号查询
	public Human_file Humanfileidselall(String human_id);
	//查询所有
	public List<Human_file> Humanfileallsel();
	//修改变更
	public void human_chack_upd(Human_file humman_file);
	//删除条件查询
	public List<Human_file> delete_list(Map map);
	//保存删除
	public void delete_update(String human_id);
}
