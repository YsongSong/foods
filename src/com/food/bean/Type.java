package com.food.bean;

/**
 * @author Administrator
 * 菜类型类
 */
public class Type {
	private int cid; //菜类型ID
	private String cidName; //菜名
	public Type() {
		super();
	}
	public Type(int cid, String cidName) {
		super();
		this.cid = cid;
		this.cidName = cidName;
	}
	public int getCid() {
		return cid;
	}
	public String getCidName() {
		return cidName;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setCidName(String cidName) {
		this.cidName = cidName;
	}
	@Override
	public String toString() {
		return "Type [cid=" + cid + ", cidName=" + cidName + "]";
	}
	
}
