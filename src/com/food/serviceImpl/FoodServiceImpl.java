package com.food.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import com.food.bean.Food;
import com.food.bean.Message;
import com.food.dao.FoodDao;
import com.food.dao.MessageDao;
import com.food.daoImpl.FoodDaoImpl;
import com.food.daoImpl.MessageDaoImpl;
import com.food.service.FoodService;
import com.food.utils.PageBean;

/**
 * 商品service层
 * @author YangSong
 */
public class FoodServiceImpl implements FoodService {
	private FoodDao dao = new FoodDaoImpl();
	private MessageDao messDao = new MessageDaoImpl();
	
	public List<Food> getAll() throws SQLException {
		String sql = "select * from t_food";
		List<Food> foods = dao.findByCondition(sql, null);
		return foods;
	}
	
	public PageBean<Food> getByPage(int pc) throws SQLException {
		PageBean<Food> list = dao.findByPage(pc);
		return list;
	}
	
	public PageBean<Message> getMessage() {
		String sql = "select * from t_message limit 0,2";
		List<Message> list = messDao.findByCondition(sql, null);
		PageBean<Message> mess = new PageBean<>();
		mess.setBeanList(list);
		return mess;
	}
}
