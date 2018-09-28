package com.zd.entity;

/**
 * 2.一级机构设置表
 * @author Administrator
 *
 */
//一级机构联动
public class Config_file_first_kind {
	public Config_file_first_kind() {
		super();
	}
	public Config_file_first_kind(int ffkid, String firstkindid, String firstkindname, int firstkindsalaryid,
			int firstkindsaleid) {
		super();
		this.ffkid = ffkid;
		this.firstkindid = firstkindid;
		this.firstkindname = firstkindname;
		this.firstkindsalaryid = firstkindsalaryid;
		this.firstkindsaleid = firstkindsaleid;
	}
	private int ffkid;
	private String firstkindid;
	private String firstkindname;
	private int firstkindsalaryid;
	private int firstkindsaleid;

	public int getFfkid() {
		return ffkid;
	}
	public void setFfkid(int ffkid) {
		this.ffkid = ffkid;
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
	public int getFirstkindsalaryid() {
		return firstkindsalaryid;
	}
	public void setFirstkindsalaryid(int firstkindsalaryid) {
		this.firstkindsalaryid = firstkindsalaryid;
	}
	public int getFirstkindsaleid() {
		return firstkindsaleid;
	}
	public void setFirstkindsaleid(int firstkindsaleid) {
		this.firstkindsaleid = firstkindsaleid;
	}
	
	
}
