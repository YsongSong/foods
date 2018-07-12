package com.food.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.food.bean.Order;
import com.food.dao.CarDao;
import com.food.dao.OrderDao;
import com.food.daoImpl.CarDaoImpl;
import com.food.daoImpl.OrderDaoImpl;
import com.food.service.OrderService;
import com.food.utils.DateUtil;
import com.food.utils.PageBean;

public class OrderServiceImpl implements OrderService {
	private OrderDao dao = new OrderDaoImpl();
	private CarDao carDao = new CarDaoImpl();
	
	public boolean createOrder(Order order) {
		String sql = "insert into t_order(quantity,total,status,ordertime,foodId,userId) values(?,?,?,?,?,?)";
		List<Object> param = new ArrayList<>();
		param.add(order.getQuantity());
		param.add(order.getTotal());
		param.add(order.getStatus());
		param.add(order.getOrdertime());
		param.add(order.getFood().getFoodId());
		param.add(order.getUser().getUserId());
		boolean flg = dao.insert(sql, param);		//执行订单添加

		sql = "DELETE FROM t_cartitem WHERE userId="+order.getUser().getUserId();
		flg = carDao.delete(sql, null); //执行删除
		return flg;
	}
	
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
	 * 按用户日期查询订单
	 * @return
	 */
	public List<Order> getOrderByTime(int userId,String ordertime) {
		String sql = "SELECT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId and u.userId=o.userId and o.userId=? and o.ordertime LIKE '%"+ordertime+"%'";
		List<Object> list = new ArrayList<>();
		list.add(userId);
		List<Order> orders = dao.findBycondition(sql,list );
		return orders;
	} 
	
	/**
	 * 按菜名查询订单
	 * @return
	 */
	public List<Order> getOrderByFood(int userId,String fname) {
		String sql = "SELECT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId and u.userId=o.userId and o.userId=? and f.fname=?";
		List<Object> list = new ArrayList<>();
		list.add(userId);
		list.add(fname);
		List<Order> orders = dao.findBycondition(sql,list );
		return orders;
	}
	
	/**
	 * 按状态查询订单
	 * @return
	 */
	public List<Order> getOrderByStatus(int userId,int status) {
		String sql = "SELECT * FROM t_food f,USER u,t_order o WHERE f.foodId=o.foodId AND u.userId=o.userId AND o.userId=? AND STATUS=?";
		List<Object> list = new ArrayList<>();
		list.add(userId);
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
	
	/**
	 * 获取销售排行榜
	 * @return
	 */
	public List<Order> getSale() {
		String sql = "select f.foodId,f.fname,sum(quantity) quantity from t_food f,t_order o where f.foodId=o.foodId group by o.foodId order by quantity desc";
		List<Order> sale = dao.findBycondition(sql, null);
		return sale;
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
