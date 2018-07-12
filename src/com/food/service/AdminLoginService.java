package com.food.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.food.bean.Admin;

public interface AdminLoginService {
	public boolean changeInfo(Admin admin);
	public void logout(HttpServletRequest request);
	public List<Admin> getAdmin(Admin admin);
}
