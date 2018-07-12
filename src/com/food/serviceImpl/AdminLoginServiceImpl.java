package com.food.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.food.bean.Admin;
import com.food.dao.UserDao;
import com.food.daoImpl.UserDaoImpl;
import com.food.service.AdminLoginService;

public class AdminLoginServiceImpl implements AdminLoginService {
	private UserDao userDao= new UserDaoImpl();
	@Override
	public boolean changeInfo(Admin admin) {
		String sql="update t_admin set adminName=?,adminPwd=? where id=?";
		List<Object> param=new ArrayList<>();
		param.add(admin.getAdminName());
		param.add(admin.getAdminPwd());
		param.add(admin.getId());
		return userDao.update(sql, param);
	}
	
	public List<Admin> getAdmin(Admin admin){
		String sql="select * from t_admin where adminName=? and adminPwd=?";
		List<Object> param=new ArrayList<>();
		param.add(admin.getAdminName());
		param.add(admin.getAdminPwd());
		return userDao.findAdmin(sql, param);
	}

	@Override
	public void logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("admin");
		session.removeAttribute("convertType");
	}

}
