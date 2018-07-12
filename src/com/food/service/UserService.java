package com.food.service;
import java.util.List;

import com.food.bean.Admin;
import com.food.bean.User;
/**
 * @author Administrator
 *用户dao（系统和普通用户）
 */
public interface UserService {
	/**
	 * @param user user包含详细信息
	 * 注册
	 */
	public boolean register(String sql,List<Object> param);
	
	/**
	 * 前台,后台登录
	 * @param user 包含登录需要的信息（姓名 密码）
	 * @return
	 * 
	 */
	public boolean login(String sql,List<Object> param);
	
	
	
	/**用于修改后台管理员信息
	 * @param admin包含的信息（姓名 密码）
	 * @return
	 */
	public boolean update(String sql,List<Object> param);
}
