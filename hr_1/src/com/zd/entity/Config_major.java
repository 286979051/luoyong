package com.zd.entity;
/**
 * 10.÷∞Œª…Ë÷√ 
 * @author Administrator
 *
 */
public class Config_major {

	
	public Config_major() {
		super();
	}
	

	public Config_major(int makid, String majorkindid, String majorkindname, String majorid, String majorname,
			int testamount) {
		super();
		this.makid = makid;
		this.majorkindid = majorkindid;
		this.majorkindname = majorkindname;
		this.majorid = majorid;
		this.majorname = majorname;
	}

	private int makid;
	private String majorkindid;
	private String majorkindname;
	private String majorid;
	private String majorname;
	
	public int getMakid() {
		return makid;
	}
	public void setMakid(int makid) {
		this.makid = makid;
	}
	public String getMajorkindid() {
		return majorkindid;
	}
	public void setMajorkindid(String majorkindid) {
		this.majorkindid = majorkindid;
	}
	public String getMajorkindname() {
		return majorkindname;
	}
	public void setMajorkindname(String majorkindname) {
		this.majorkindname = majorkindname;
	}
	public String getMajorid() {
		return majorid;
	}
	public void setMajorid(String majorid) {
		this.majorid = majorid;
	}
	public String getMajorname() {
		return majorname;
	}
	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	@Override
	public String toString() {
		return "Config_major [makid=" + makid + ", majorkindid=" + majorkindid + ", majorkindname=" + majorkindname
				+ ", majorid=" + majorid + ", majorname=" + majorname + "]";
	}
	
}
