package com.food.bean;

/**
 * @author Administrator
 *订单类
 */
public class Order {
//	private int foodId; //食品ID
	private int oderId;//订单ID
	private String ordertime;//订单时间,工具类转换
	private int quantity; //数量
	private int status; //是否已派送 0或1
	private float total; //总计
//	private int userId; //用户ID
	
	private User user;
	private Food food;
	
	public Order() {
		super();
	}
//	public Order(int oderId, int quantity, float total, char status, String ordertime, int foodId, int userId) {
//		super();
//		this.oderId = oderId;
//		this.quantity = quantity;
//		this.total = total;
//		this.status = status;
//		this.ordertime = ordertime;
//		this.foodId = foodId;
//		this.userId = userId;
//	}
//	public int getFoodId() {
//		return foodId;
//	}
	public int getOderId() {
		return oderId;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getStatus() {
		return status;
	}
	public float getTotal() {
		return total;
	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setFoodId(int foodId) {
//		this.foodId = foodId;
//	}
	public void setOderId(int oderId) {
		this.oderId = oderId;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setTotal(float total) {
		this.total = total;
	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	@Override
//	public String toString() {
//		return "Order [oderId=" + oderId + ", quantity=" + quantity + ", total=" + total + ", status=" + status
//				+ ", ordertime=" + ordertime + ", foodId=" + foodId + ", userId=" + userId + "]";
//	}
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	@Override
	public String toString() {
		return "Order [oderId=" + oderId + ", ordertime=" + ordertime + ", quantity=" + quantity + ", status=" + status
				+ ", total=" + total + ", user=" + user + ", food=" + food + "]";
	}
	
	public Order(int oderId, String ordertime, int quantity, char status, float total, User user, Food food) {
		super();
		this.oderId = oderId;
		this.ordertime = ordertime;
		this.quantity = quantity;
		this.status = status;
		this.total = total;
		this.user = user;
		this.food = food;
	}
	
	
}
