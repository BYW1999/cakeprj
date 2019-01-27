package com.by.bycake.entity;

public class Type {
	private int typeid;
	private String typename;
	private int fatypeid;
	
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int getFatypeid() {
		return fatypeid;
	}
	public void setFatypeid(int fatypeid) {
		this.fatypeid = fatypeid;
	}
	
	@Override
	public String toString() {
		return "Type [typeid=" + typeid + ", typename=" + typename + ", fatypeid=" + fatypeid + "]";
	}
}
