package com.food.service;

import com.food.bean.Cartitem;
import com.food.utils.PageBean;

public interface CartService {
	/**
	 * 添加条目
	 * @param cartItem
	 */
	public void add(Cartitem cartitem);
	/**
	 * 查询餐车数据
	 * @param cartItem
	 */
	public PageBean<Cartitem> getItem(int userId);
	
	/**
	 * 删除所有
	 * @param userId
	 */
	public void deleteAll(int userId);
}
