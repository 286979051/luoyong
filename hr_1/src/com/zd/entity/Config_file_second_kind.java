package com.zd.entity;

public class Config_file_second_kind {

	
	//二级联动
	public Config_file_second_kind() {
		super();
	}
	public Config_file_second_kind(int fskid, int firstkindid, String firstkindname, int secondkindid,
			String secondkindname, int secondsalaryid, int secondsaleid) {
		super();
		this.fskid = fskid;
		this.firstkindid = firstkindid;
		this.firstkindname = firstkindname;
		this.secondkindid = secondkindid;
		this.secondkindname = secondkindname;
		this.secondsalaryid = secondsalaryid;
		this.secondsaleid = secondsaleid;
	}
	private int fskid;
	private int firstkindid;
	private String firstkindname;
	private int secondkindid;
	private String secondkindname;
	private int secondsalaryid;
	private int secondsaleid;
	public int getFskid() {
		return fskid;
	}
	public void setFskid(int fskid) {
		this.fskid = fskid;
	}
	public int getFirstkindid() {
		return firstkindid;
	}
	public void setFirstkindid(int firstkindid) {
		this.firstkindid = firstkindid;
	}
	public String getFirstkindname() {
		return firstkindname;
	}
	public void setFirstkindname(String firstkindname) {
		this.firstkindname = firstkindname;
	}
	public int getSecondkindid() {
		return secondkindid;
	}
	public void setSecondkindid(int secondkindid) {
		this.secondkindid = secondkindid;
	}
	public String getSecondkindname() {
		return secondkindname;
	}
	public void setSecondkindname(String secondkindname) {
		this.secondkindname = secondkindname;
	}
	public int getSecondsalaryid() {
		return secondsalaryid;
	}
	public void setSecondsalaryid(int secondsalaryid) {
		this.secondsalaryid = secondsalaryid;
	}
	public int getSecondsaleid() {
		return secondsaleid;
	}
	public void setSecondsaleid(int secondsaleid) {
		this.secondsaleid = secondsaleid;
	}
	
}
