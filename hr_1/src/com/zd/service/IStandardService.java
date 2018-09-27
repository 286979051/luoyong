package com.zd.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.zd.entity.Salary_standard;
/**
 * 
 * @author ’≈√Ù
 *
 */
@Service
public interface IStandardService {
	
	public void addstandard(Salary_standard salary_standard);
	
	public void addzm_some(Map map);
}
