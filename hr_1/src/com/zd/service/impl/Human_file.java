package com.zd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IHuman_fileDao;
import com.zd.service.IHuman_fileservice;

@Service
public class Human_file implements IHuman_fileservice {
	@Autowired
	private IHuman_fileDao human_file;
	//Ìí¼Ó
	public void add(com.zd.entity.Human_file humman_file) {
		human_file.add(humman_file);
	}

}
