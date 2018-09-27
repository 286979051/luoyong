package com.zd.entity;

public class Config_major {

	
	public Config_major() {
		super();
	}
	
	public Config_major(int makid, int majorkindid, String majorkindname, int majorid, String majorname,
			int testamount) {
		super();
		this.makid = makid;
		this.majorkindid = majorkindid;
		this.majorkindname = majorkindname;
		this.majorid = majorid;
		this.majorname = majorname;
		this.testamount = testamount;
	}

	private int makid;
	private int majorkindid;
	private String majorkindname;
	private int majorid;
	private String majorname;
	private int testamount;
	public int getMakid() {
		return makid;
	}
	public void setMakid(int makid) {
		this.makid = makid;
	}
	public int getMajorkindid() {
		return majorkindid;
	}
	public void setMajorkindid(int majorkindid) {
		this.majorkindid = majorkindid;
	}
	public String getMajorkindname() {
		return majorkindname;
	}
	public void setMajorkindname(String majorkindname) {
		this.majorkindname = majorkindname;
	}
	public int getMajorid() {
		return majorid;
	}
	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}
	public String getMajorname() {
		return majorname;
	}
	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}
	public int getTestamount() {
		return testamount;
	}
	public void setTestamount(int testamount) {
		this.testamount = testamount;
	}

	@Override
	public String toString() {
		return "Config_major [makid=" + makid + ", majorkindid=" + majorkindid + ", majorkindname=" + majorkindname
				+ ", majorid=" + majorid + ", majorname=" + majorname + ", testamount=" + testamount + "]";
	}

	
}
