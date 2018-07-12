package com.food.daoImpl;

import java.util.List;
import java.util.Map;

import com.food.bean.Message;
import com.food.bean.Order;
import com.food.dao.OrderDao;
import com.food.utils.ConvertUtils;
import com.food.utils.DBUtils;

public class OrderDaoImpl implements OrderDao {

	@Override
	public List<Order> findBycondition(String sql, List<Object> param) {
		List<Map<String, Object>> list= DBUtils.executeQuery(sql, param);
		return (List<Order>) ConvertUtils.convert(list, Order.class);
	}

	@Override
	public boolean insert(String sql, List<Object> param) {
		return DBUtils.executeUpdate(sql, param);
	}

	

}
