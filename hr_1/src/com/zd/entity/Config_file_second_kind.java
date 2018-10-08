package com.zd.entity;
/**
 * 3.二级机构设置表
 * @author Administrator
 *
 */
public class Config_file_second_kind {

	
	//二级联动
	public Config_file_second_kind() {
		super();
	}
	public Config_file_second_kind(int fskid, String firstkindid, String firstkindname, String secondkindid,
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
	private String firstkindid;
	private String firstkindname;
	private String secondkindid;
	private String secondkindname;
	private int secondsalaryid;
	private int secondsaleid;
	public int getFskid() {
		return fskid;
	}
	public void setFskid(int fskid) {
		this.fskid = fskid;
	}
	public String getFirstkindid() {
		return firstkindid;
	}
	public void setFirstkindid(String firstkindid) {
		this.firstkindid = firstkindid;
	}
	public String getFirstkindname() {
		return firstkindname;
	}
	public void setFirstkindname(String firstkindname) {
		this.firstkindname = firstkindname;
	}
	public String getSecondkindid() {
		return secondkindid;
	}
	public void setSecondkindid(String secondkindid) {
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
	@Override
	public String toString() {
		return "Config_file_second_kind [fskid=" + fskid + ", firstkindid=" + firstkindid + ", firstkindname="
				+ firstkindname + ", secondkindid=" + secondkindid + ", secondkindname=" + secondkindname
				+ ", secondsalaryid=" + secondsalaryid + ", secondsaleid=" + secondsaleid + "]";
	}
}
