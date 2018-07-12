package com.food.serviceImpl;

import java.util.List;

import com.food.dao.UserDao;
import com.food.daoImpl.UserDaoImpl;
import com.food.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl(); 

	@Override
	public boolean register(String sql, List<Object> param) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(String sql, List<Object> param) {
		// TODO Auto-generated method stub
		
		
		
		
		return userDao.login(sql, param);
	}

	@Override
	public boolean update(String sql, List<Object> param) {
		// TODO Auto-generated method stub
		return false;
	}

}
