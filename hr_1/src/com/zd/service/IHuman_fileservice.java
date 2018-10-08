package com.zd.service;

import java.util.List;

import com.zd.entity.Config_shang;
import com.zd.entity.Human_file;

public interface IHuman_fileservice {
	//添加
	public void add(Human_file humman_file);
	//查询所有
	public List<Human_file> Humanfileselall();
	//修改图片
	public void update(Config_shang shang);
	//修改
	public void human_chack_update(Human_file humman_file);
}
