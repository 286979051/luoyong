package com.zd.service;

import java.util.List;

import org.springframework.stereotype.Service;
/**
 * ������service
 */
import com.zd.entity.Config_public_char;

@Service
public interface IConfig_public_charservice {
	//��ѯ��������
	public List<Config_public_char> queryall();
}
