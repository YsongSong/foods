package com.food.daoImpl;

import java.util.List;
import java.util.Map;

import com.food.bean.Admin;
import com.food.bean.User;
import com.food.dao.UserDao;
import com.food.utils.ConvertUtils;
import com.food.utils.DBUtils;

public class UserDaoImpl implements UserDao{
	@Override
	public boolean register(String sql, List<Object> param) {
		return DBUtils.executeUpdate(sql, param);
	}

	@Override
	public boolean login(String sql, List<Object> param) {
		return DBUtils.executeUpdate(sql, param);
	}

	@Override
	public boolean update(String sql, List<Object> param) {
		return DBUtils.executeUpdate(sql, param);
	}

	@Override
	public List<User> findUser(String sql, List<Object> param) {
		List<Map<String, Object>> list= DBUtils.executeQuery(sql, param);
		return (List<User>) ConvertUtils.convert(list, User.class);
	}

	@Override
	public List<Admin> findAdmin(String sql, List<Object> param) {
		List<Map<String, Object>> list=DBUtils.executeQuery(sql, param);
		return (List<Admin>) ConvertUtils.convert(list, Admin.class);
	}
	
}
