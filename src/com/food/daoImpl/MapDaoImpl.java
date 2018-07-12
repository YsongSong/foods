package com.food.daoImpl;

import java.util.List;
import java.util.Map;

import com.food.bean.Dish;
import com.food.bean.Food;
import com.food.dao.MapDao;
import com.food.utils.ConvertUtils;
import com.food.utils.DBUtils;

public class MapDaoImpl implements MapDao {

	@Override
	public List<Dish> findAll(String sql, List<Object> param) {
		List<Map<String, Object>> list= DBUtils.executeQuery(sql, param);
		return (List<Dish>) ConvertUtils.convert(list, Dish.class);
	}

}
