package com.zd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IHuman_fileDao;
import com.zd.entity.Config_shang;
import com.zd.service.IHuman_fileservice;

@Service
public class Human_file implements IHuman_fileservice {
	@Autowired
	private IHuman_fileDao human_file;
	//添加
	public void add(com.zd.entity.Human_file humman_file) {
		human_file.add(humman_file);
	}
	//查询所有
	public List<com.zd.entity.Human_file> Humanfileselall(){
		return human_file.Humanfileselall();
	}
	
	public void update(Config_shang shang) {
		human_file.update(shang);
	}
	//修改
	public void human_chack_update(com.zd.entity.Human_file humman_file) {
		human_file.human_chack_update(humman_file);
	}
}
