package com.zd.entity;
/**
 *  1.”√ªß±Ì
 * @author Administrator
 *
 */
public class user {
	private int userid;
	private String user_name;
	private String user_true_name;
	private String user_password;
	private int user_phoneNumber;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_true_name() {
		return user_true_name;
	}
	public void setUser_true_name(String user_true_name) {
		this.user_true_name = user_true_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	public user(int userid, String user_name, String user_true_name, String user_password, int user_phoneNumber) {
		super();
		this.userid = userid;
		this.user_name = user_name;
		this.user_true_name = user_true_name;
		this.user_password = user_password;
		this.user_phoneNumber = user_phoneNumber;
	}
	public user() {
		super();
	}
	
	public int getUser_phoneNumber() {
		return user_phoneNumber;
	}
	public void setUser_phoneNumber(int user_phoneNumber) {
		this.user_phoneNumber = user_phoneNumber;
	}
	
	
}
