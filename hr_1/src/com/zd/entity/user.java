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
	public user(int userid, String user_name, String user_true_name, String user_password) {
		super();
		this.userid = userid;
		this.user_name = user_name;
		this.user_true_name = user_true_name;
		this.user_password = user_password;
	}
	public user() {
		super();
	}
	@Override
	public String toString() {
		return "user [userid=" + userid + ", user_name=" + user_name + ", user_true_name=" + user_true_name
				+ ", user_password=" + user_password + "]";
	}
	
	
}
