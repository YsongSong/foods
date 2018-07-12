package com.food.service;

import java.util.List;

import com.food.bean.Order;
import com.food.utils.PageBean;

public interface OrderService {
	
	/**
	 * 创建订单
	 * @param order
	 * @return
	 */
	public boolean createOrder(Order order);
	/**
	 * 查询所有订单
	 * @return
	 */
	public List<Order> getOrder();
	/**
	 * 按用户日期查询订单
	 * @return
	 */
	public List<Order> getOrderByTime(int userId,String ordertime);
	/**
	 * 按菜名查询订单
	 * @return
	 */
	public List<Order> getOrderByFood(int userId,String fname);
	/**
	 * 按状态查询订单
	 * @return
	 */
	public List<Order> getOrderByStatus(int userId,int status);
	/**
	 * 按用户Id查询订单
	 * @return
	 */
	public List<Order> getOrderByUserId(int userId);
	/**
	 * 查询今天所有订单订单
	 * @return
	 */
	public PageBean<Order> getSaleList();
	/**
	 * 获取销售排行榜
	 * @return
	 */
	public List<Order> getSale();
}
