package com.food.daoImpl;

import java.util.List;
import java.util.Map;

import com.food.bean.Cartitem;
import com.food.bean.Message;
import com.food.dao.CarDao;
import com.food.utils.ConvertUtils;
import com.food.utils.DBUtils;

public class CarDaoImpl implements CarDao {

	@Override
	public List<Cartitem> findByCondition(String sql, List<Object> param) {
		List<Map<String, Object>> list= DBUtils.executeQuery(sql, param);
		return (List<Cartitem>) ConvertUtils.convert(list, Cartitem.class);
	}

	@Override
	public boolean insert(String sql, List<Object> param) {
		return DBUtils.executeUpdate(sql, param);
	}

	@Override
	public boolean delete(String sql, List<Object> param) {
		return DBUtils.executeUpdate(sql, param);
	}

}
