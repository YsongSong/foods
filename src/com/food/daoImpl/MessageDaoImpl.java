package com.food.daoImpl;

import java.util.List;
import java.util.Map;

import com.food.bean.Food;
import com.food.bean.Message;
import com.food.dao.MessageDao;
import com.food.utils.ConvertUtils;
import com.food.utils.DBUtils;

public class MessageDaoImpl implements MessageDao {

	@Override
	public List<Message> findByCondition(String sql, List<Object> param) {
		List<Map<String, Object>> list= DBUtils.executeQuery(sql, param);
		return (List<Message>) ConvertUtils.convert(list, Message.class);
	}

	@Override
	public boolean insert(String sql, List<Object> param) {
		return DBUtils.executeUpdate(sql, param);
	}

	@Override
	public boolean delete(String sql, List<Object> param) {
		return DBUtils.executeUpdate(sql, param);
	}

	@Override
	public boolean update(String sql, List<Object> param) {
		return DBUtils.executeUpdate(sql, param);
	}

	

}
