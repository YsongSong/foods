package com.food.bean;

/**
 * @author Administrator
 * 管理员类
 */
public class Admin {
	private String adminName;  //姓名
	private String adminPwd;   //密码
	private int id;
	public Admin() {
		super();
	}
	public Admin(String adminName, String adminPwd) {
		super();
		this.adminName = adminName;
		this.adminPwd = adminPwd;
	}
	
	public Admin(String adminName, String adminPwd, int id) {
		super();
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.id = id;
	}
	
	public Admin(int id, String adminName, String adminPwd) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
	}
	public String getAdminName() {
		return adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminPwd=" + adminPwd + ", id=" + id + "]";
	}
}
