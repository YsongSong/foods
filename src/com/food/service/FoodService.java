package com.food.service;

import java.sql.SQLException;
import java.util.List;

import com.food.bean.Food;
import com.food.bean.Message;
import com.food.utils.PageBean;

public interface FoodService {
	/**
	 * 获取所有菜品
	 * @return
	 * @throws SQLException
	 */
	public List<Food> getAll() throws SQLException;
	
	/**
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Food> getByPage(int pc) throws SQLException;
	
	/**
	 * @return
	 */
	public PageBean<Message> getMessage();
}
