package com.zd.entity;

public class Config_major_kind {

	
	public Config_major_kind() {
		super();
	}
	
	public Config_major_kind(int mfkid, int majorkindid, String majorkindname) {
		super();
		this.mfkid = mfkid;
		this.majorkindid = majorkindid;
		this.majorkindname = majorkindname;
	}

	private int mfkid;
	private int majorkindid;
	private String majorkindname;
	
	public int getMfkid() {
		return mfkid;
	}

	public void setMfkid(int mfkid) {
		this.mfkid = mfkid;
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
	
	
}
