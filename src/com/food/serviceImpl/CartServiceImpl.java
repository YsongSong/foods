package com.food.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.food.bean.Cartitem;
import com.food.dao.CarDao;
import com.food.daoImpl.CarDaoImpl;
import com.food.service.CartService;
import com.food.utils.PageBean;

public class CartServiceImpl implements CartService {
	
	private CarDao dao = new CarDaoImpl();
	/**
	 * 添加条目
	 * @param cartItem
	 */
	public void add(Cartitem cartitem) {
		/*
		 * 1. 使用foodId和cartitemId,userId去数据库中查询这个条目是否存在
		 */
		String sql="select * from t_cartitem c,t_food f where c.foodId=f.foodId and c.foodId=? and c.userId=?";
		List<Object> param1 = new ArrayList<>();
		param1.add(cartitem.getFood().getFoodId());
		param1.add(cartitem.getUserId());
		List<Cartitem> list = dao.findByCondition(sql, param1);
		//餐车没有此数据添加之，否则添加数量
		if(list.size()==0) {
			sql="insert into t_cartitem(quantity,foodId,userId) values(1,?,?)";
			List<Object> param = new ArrayList<>();
			param.add(cartitem.getFood().getFoodId());
			param.add(cartitem.getUserId());
			dao.insert(sql, param);
		} else {
			sql="update t_cartitem set quantity=quantity + 1 where foodId=? and userId=?";
			List<Object> param = new ArrayList<>();
			param.add(cartitem.getFood().getFoodId());
			param.add(cartitem.getUserId());
			dao.insert(sql, param);
		}
	}
	
	/**
	 * 查询餐车数据
	 * @param cartItem
	 */
	public PageBean<Cartitem> getItem(int userId) {
		/*
		 * 1. 使用userId查询
		 */
//		String sql="select * from t_cartitem c,t_food f where c.foodId=f.foodId and c.userId=?";
		String sql = "SELECT cartitemId, quantity,userId, SUM(quantity) total, SUM(currPrice*quantity) subtotal FROM t_cartitem c,t_food f WHERE c.foodId=f.foodId AND c.userId=?";
		List<Object> param1 = new ArrayList<>();
		param1.add(userId);
		List<Cartitem> list = dao.findByCondition(sql, param1);//计算总计和总数量
		Cartitem cartItem = list.get(0);
		
		sql="select * from t_cartitem c,t_food f where c.foodId=f.foodId and c.userId=?";
		List<Cartitem> list2 = dao.findByCondition(sql, param1);//获取用户所有餐车数据
		PageBean<Cartitem> pb = new PageBean<Cartitem>();	//添加页面数据
		pb.setBeanList(list2);
		pb.setSubtotal(cartItem.getSubtotal());
		pb.setTotal(cartItem.getTotal());
		
		return pb;
	}
	
	public void deleteAll(int userId) {
		String sql = "DELETE FROM t_cartitem WHERE userId="+userId;
		dao.delete(sql, null);
	}
}
