package com.zd.entity;

/**
 * 用户的上传与下载表
 * @author Administrator
 *
 */
public class Config_shang {
	private String pbc_id;// INT PRIMARY KEY,
	private String attribute_kind ;//VARCHAR(60),
	private String attribute_name;// VARCHAR(60)
	
	
	public Config_shang() {
		super();
	}




	public Config_shang(String pbc_id, String attribute_kind, String attribute_name) {
		super();
		this.pbc_id = pbc_id;
		this.attribute_kind = attribute_kind;
		this.attribute_name = attribute_name;
	}




	public String getPbc_id() {
		return pbc_id;
	}




	public void setPbc_id(String pbc_id) {
		this.pbc_id = pbc_id;
	}




	public String getAttribute_kind() {
		return attribute_kind;
	}


	public void setAttribute_kind(String attribute_kind) {
		this.attribute_kind = attribute_kind;
	}


	public String getAttribute_name() {
		return attribute_name;
	}


	public void setAttribute_name(String attribute_name) {
		this.attribute_name = attribute_name;
	}
	
	
}
