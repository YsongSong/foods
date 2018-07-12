package com.food.dao;

import java.util.List;

import com.food.bean.Order;

/**
 * @author Administrator
 *订单DAO
 */
public interface OrderDao {
	/**
	 * 插入订单
	 * @param order
	 */
	public boolean insert(String sql,List<Object> param);
	
	/**
	 * 可根据相应条件查询订单
	 * @param sql
	 * @param param
	 * @return
	 */
	public List<Order> findBycondition(String sql,List<Object> param);
}
