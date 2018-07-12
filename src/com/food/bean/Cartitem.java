package com.food.bean;

/**
 * @author Administrator
 *购物车类
 */
public class Cartitem {
    private int cartitemId;  //餐车ID， 主键
//    private int foodId;      //食品ID  外键
    private int quantity;    //食品数量
	private int userId;      //用户ID   外键
	
	private Food food;
	private int total;		//总数量
	private double subtotal;	//总价格
	
	public Cartitem() {
		super();
	}
//	public Cartitem(int cartitemId, int foodId, int userId, int quantity) {
//		super();
//		this.cartitemId = cartitemId;
//		this.foodId = foodId;
//		this.userId = userId;
//		this.quantity = quantity;
//	}
	public int getCartitemId() {
		return cartitemId;
	}
//	public int getFoodId() {
//		return foodId;
//	}
	public int getQuantity() {
		return quantity;
	}
	public int getUserId() {
		return userId;
	}
	public void setCartitemId(int cartitemId) {
		this.cartitemId = cartitemId;
	}
//	public void setFoodId(int foodId) {
//		this.foodId = foodId;
//	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
//    @Override
//	public String toString() {
//		return "Cartitem [cartitemId=" + cartitemId + ", foodId=" + foodId + ", userId=" + userId + ", quantity="
//				+ quantity + "]";
//	}
	
	
	public Food getFood() {
		return food;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	@Override
	public String toString() {
		return "Cartitem [cartitemId=" + cartitemId + ", quantity=" + quantity + ", userId=" + userId + ", food=" + food
				+ ", total=" + total + ", subtotal=" + subtotal + "]";
	}
	public Cartitem(int cartitemId, int quantity, int userId, Food food, int total, double subtotal) {
		super();
		this.cartitemId = cartitemId;
		this.quantity = quantity;
		this.userId = userId;
		this.food = food;
		this.total = total;
		this.subtotal = subtotal;
	}
	
    
    
}
