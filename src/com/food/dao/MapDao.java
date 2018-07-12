package com.food.dao;

import java.util.List;

import com.food.bean.Dish;

public interface MapDao {
	public List<Dish> findAll(String sql,List<Object> param);
}
