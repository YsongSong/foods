package com.food.bean;

/**
 * @author Administrator
 *用户类
 */
public class User {
	private String userAddress;//地址
	private int userAge;   //年龄
	private String userEmail;//email
	private int userId; //用户ID
	private String userName;//用户名
	private String userNum; //身份证
	private String userPhone;//电话
	private String userPostNum;//邮编
	private String userPwd; //用户密码
	private String userSex;//用户性别
	public User() {
		super();
	}
	public User(String userAddress, int userAge, String userEmail, int userId, String userName, String userNum,
			String userPhone, String userPostNum, String userPwd, String userSex) {
		super();
		this.userAddress = userAddress;
		this.userAge = userAge;
		this.userEmail = userEmail;
		this.userId = userId;
		this.userName = userName;
		this.userNum = userNum;
		this.userPhone = userPhone;
		this.userPostNum = userPostNum;
		this.userPwd = userPwd;
		this.userSex = userSex;
	}
	
	public User(String userName,String userPwd,String userSex,int userAge,String userNum,String
			userAddress,String userPhone,String userEmail,String userPostNum){
		this.userName=userName;
		this.userPwd=userPwd;
		this.userSex=userSex;
		this.userAge=userAge;
		this.userNum=userNum;
		this.userAddress=userAddress;
		this.userPhone=userPhone;
		this.userEmail=userEmail;
		this.userPostNum=userPostNum;
		
	}
	
	public String getUserAddress() {
		return userAddress;
	}
	public int getUserAge() {
		return userAge;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserNum() {
		return userNum;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public String getUserPostNum() {
		return userPostNum;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public void setUserPostNum(String userPostNum) {
		this.userPostNum = userPostNum;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userSex=" + userSex
				+ ", userAge=" + userAge + ", userNum=" + userNum + ", userAddress=" + userAddress + ", userPhone="
				+ userPhone + ", userEmail=" + userEmail + ", userPostNum=" + userPostNum + "]";
	}
}
