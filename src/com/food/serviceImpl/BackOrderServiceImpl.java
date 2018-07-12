package com.food.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.food.bean.Order;
import com.food.dao.OrderDao;
import com.food.daoImpl.OrderDaoImpl;
import com.food.service.BackOrderService;
import com.food.utils.DateUtil;
import com.food.utils.PageBean;

public class BackOrderServiceImpl implements BackOrderService {
	private OrderDao dao = new OrderDaoImpl();
	
	/**
	 * 查询所有订单
	 * @return
	 */
	public List<Order> getOrder() {
		String sql = "SELECT DISTINCT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId AND u.userId=o.userId";
		List<Order> orders = dao.findBycondition(sql, null);
		return orders;
	}
	
	/**
	 * 按日期查询订单
	 * @return
	 */
	public List<Order> getOrderByTime(String ordertime) {
		String sql = "SELECT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId and u.userId=o.userId and o.ordertime LIKE '%"+ordertime+"%'";
		List<Order> orders = dao.findBycondition(sql,null );
		return orders;
	} 
	
	/**
	 * 按菜名查询订单
	 * @return
	 */
	public List<Order> getOrderByFood(String fname) {
		String sql = "SELECT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId and u.userId=o.userId and f.fname=?";
		List<Object> list = new ArrayList<>();
		list.add(fname);
		List<Order> orders = dao.findBycondition(sql,list );
		return orders;
	}
	
	/**
	 * 按状态查询订单
	 * @return
	 */
	public List<Order> getOrderByStatus(int status) {
		String sql = "SELECT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId AND u.userId=o.userId AND STATUS=?";
		List<Object> list = new ArrayList<>();
		list.add(status);
		List<Order> orders = dao.findBycondition(sql,list );
		return orders;
	}
	
//	SELECT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId AND ordertime LIKE '%2018-01-08%';
	
	/**
	 * 按用户Id查询订单
	 * @return
	 */
	public List<Order> getOrderByUserId(int userId) {
		String sql = "SELECT DISTINCT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId AND u.userId=o.userId AND o.userId=?";
		List<Object> list = new ArrayList<>();
		list.add(userId);
		List<Order> orders = dao.findBycondition(sql,list );
		return orders;
	} 
	
	
	/**
	 * 确认订单(派送)
	 * @return
	 */
	public boolean sureOrder(int orderId) {
		String sql = "update t_order set status=1 where oderId=?";
		List<Object> list = new ArrayList<>();
		list.add(orderId);
		boolean flg = dao.insert(sql, list);
		return flg;
	}
	
	
	// 前台一样
	
	/**
	 * 查询今天所有订单订单
	 * @return
	 */
	public PageBean<Order> getSaleList() {
		String date = DateUtil.formatDate(new Date(), "yyyy-MM-dd");
		System.out.println(date);
//		String sql = "SELECT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId AND ordertime LIKE '%"+date+"%'";
		String sql = "SELECT * FROM t_food f,t_order o WHERE f.foodId=o.foodId AND ordertime LIKE '%"+date+"%'";
		List<Order> orders = dao.findBycondition(sql, null);
		
		sql = "SELECT SUM(total) total FROM t_food f,t_order o WHERE f.foodId=o.foodId AND  ordertime LIKE '%"+date+"%'";  //统计总价
		List<Order> total = dao.findBycondition(sql, null); //单独封装的对象  里面只有total
		PageBean<Order> pb = new PageBean<>();
		pb.setBeanList(orders);
		pb.setSubtotal(total.get(0).getTotal());
		return pb;
	}
	
//	SELECT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId AND ordertime LIKE '%2018-01-08%';
	
	
	public static void main(String[] args) {
		System.out.println(String.format("%tF %<tT", new Date()));//当前时间
		System.out.println(DateUtil.formatDate(new Date(), "yyyy-MM-dd"));
		OrderDao order = new OrderDaoImpl();
		//按用户查询
//		String sql = "SELECT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId AND u.userId=1;";
//		List<Order> list = order.findBycondition(sql, null);
//		System.out.println(list);
		
//		String sql = "SELECT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId AND ordertime LIKE '%"+123+"%'";
//		List<Order> orders = order.findBycondition(sql, null);
		
		String date = DateUtil.formatDate(new Date(), "yyyy-MM-dd");
		System.out.println(date);
		String sql = "SELECT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId AND ordertime LIKE '%"+date+"%'";
		List<Order> orders = order.findBycondition(sql, null);
		
		sql = "SELECT SUM(total) total FROM t_food f,t_order o WHERE f.foodId=o.foodId AND  ordertime LIKE '%"+date+"%'";  //统计总价
		List<Order> total = order.findBycondition(sql, null); //单独封装的对象  里面只有total
		PageBean<Order> pb = new PageBean<>();
		pb.setBeanList(orders);
		pb.setSubtotal(total.get(0).getTotal());
		System.out.println(pb);
	}
}
