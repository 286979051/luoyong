package com.zd.entity;

public class e_mail {
	private int e_id;
	private String e_title;
	private String e_content;
	private int e_type;
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getE_title() {
		return e_title;
	}
	public void setE_title(String e_title) {
		this.e_title = e_title;
	}
	public String getE_content() {
		return e_content;
	}
	public void setE_content(String e_content) {
		this.e_content = e_content;
	}
	public int getE_type() {
		return e_type;
	}
	public void setE_type(int e_type) {
		this.e_type = e_type;
	}
	public e_mail(int e_id, String e_title, String e_content, int e_type) {
		super();
		this.e_id = e_id;
		this.e_title = e_title;
		this.e_content = e_content;
		this.e_type = e_type;
	}
	public e_mail() {
		super();
	}
	
	
}
