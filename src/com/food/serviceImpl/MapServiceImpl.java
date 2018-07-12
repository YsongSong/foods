package com.food.serviceImpl;

import java.util.List;
import com.food.bean.Dish;
import com.food.dao.MapDao;
import com.food.daoImpl.MapDaoImpl;
import com.food.service.MapService;

public class MapServiceImpl implements MapService {
	private MapDao mapDao=new MapDaoImpl();
	@Override
	public List<Dish> getMapData() {
		String sql="select * from t_dish";
		return mapDao.findAll(sql, null);
	}

}
