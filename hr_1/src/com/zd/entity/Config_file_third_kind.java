package com.zd.entity;

/**
 * 4.三级机构设置表
 * @author Administrator
 *
 */
//三级联动
public class Config_file_third_kind {

	
	public Config_file_third_kind() {
		super();
	}
	
	public Config_file_third_kind(int ftkid, int firstkindid, String firstkindname, int secondkindid,
			String secondkindname, int thirdkindid, String thirdkindname, int thirdkindsaleid, int thirdkindisretail) {
		super();
		this.ftkid = ftkid;
		this.firstkindid = firstkindid;
		this.firstkindname = firstkindname;
		this.secondkindid = secondkindid;
		this.secondkindname = secondkindname;
		this.thirdkindid = thirdkindid;
		this.thirdkindname = thirdkindname;
		this.thirdkindsaleid = thirdkindsaleid;
		this.thirdkindisretail = thirdkindisretail;
	}

	private int ftkid;
	private int firstkindid;
	private String firstkindname;
	private int secondkindid;
	private String secondkindname;
	private int thirdkindid;
	private String thirdkindname;
	private int thirdkindsaleid;
	private int thirdkindisretail;
	
	public int getFtkid() {
		return ftkid;
	}
	public void setFtkid(int ftkid) {
		this.ftkid = ftkid;
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
	public int getThirdkindid() {
		return thirdkindid;
	}
	public void setThirdkindid(int thirdkindid) {
		this.thirdkindid = thirdkindid;
	}
	public String getThirdkindname() {
		return thirdkindname;
	}
	public void setThirdkindname(String thirdkindname) {
		this.thirdkindname = thirdkindname;
	}
	public int getThirdkindsaleid() {
		return thirdkindsaleid;
	}
	public void setThirdkindsaleid(int thirdkindsaleid) {
		this.thirdkindsaleid = thirdkindsaleid;
	}
	public int getThirdkindisretail() {
		return thirdkindisretail;
	}
	public void setThirdkindisretail(int thirdkindisretail) {
		this.thirdkindisretail = thirdkindisretail;
	}

	@Override
	public String toString() {
		return "Config_file_third_kind [ftkid=" + ftkid + ", firstkindid=" + firstkindid + ", firstkindname="
				+ firstkindname + ", secondkindid=" + secondkindid + ", secondkindname=" + secondkindname
				+ ", thirdkindid=" + thirdkindid + ", thirdkindname=" + thirdkindname + ", thirdkindsaleid="
				+ thirdkindsaleid + ", thirdkindisretail=" + thirdkindisretail + "]";
	}
	
	
}
