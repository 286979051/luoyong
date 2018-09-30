package com.zd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zd.dao.IConfig_shangDao;
import com.zd.service.IConfig_sahngService;

@Service
public class Config_sahngService implements IConfig_sahngService {
	@Autowired
	private IConfig_shangDao Config_shang;
	
	public void add(com.zd.entity.Config_shang shang) {
		Config_shang.add(shang);
	}

}
