package com.zd.entity;
/**
 * zm_some
 * @author ’≈√Ù
 *
 */
public class zm_some {

	private String standard_id;
	private int pbc_id;
	private int money;
	
	public String getStandard_id() {
		return standard_id;
	}
	public void setStandard_id(String standard_id) {
		this.standard_id = standard_id;
	}
	public int getPbc_id() {
		return pbc_id;
	}
	public void setPbc_id(int pbc_id) {
		this.pbc_id = pbc_id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public zm_some() {
		
	}
	public zm_some(String standard_id, int pbc_id, int money) {
		super();
		this.standard_id = standard_id;
		this.pbc_id = pbc_id;
		this.money = money;
	}
}
