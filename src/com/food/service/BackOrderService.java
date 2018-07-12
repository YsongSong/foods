package com.food.service;

import java.util.List;

import com.food.bean.Order;
import com.food.utils.PageBean;

public interface BackOrderService {
	/**
	 * 查询所有订单
	 * @return
	 */
	public List<Order> getOrder();
	/**
	 * 按日期查询订单
	 * @return
	 */
	public List<Order> getOrderByTime(String ordertime);
	/**
	 * 按菜名查询订单
	 * @return
	 */
	public List<Order> getOrderByFood(String fname);
	/**
	 * 按状态查询订单
	 * @return
	 */
	public List<Order> getOrderByStatus(int status);
	/**
	 * 按用户Id查询订单
	 * @return
	 */
	public List<Order> getOrderByUserId(int userId);
	/**
	 * 确认订单(派送)
	 * @return
	 */
	public boolean sureOrder(int orderId);
	/**
	 * 查询今天所有订单订单
	 * @return
	 */
	public PageBean<Order> getSaleList();
}
