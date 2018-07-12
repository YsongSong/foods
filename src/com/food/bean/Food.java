package com.food.bean;

/**
 * @author Administrator
 *食品类
 */
public class Food {
	
	private Type type;
	
//	private int cid;   //菜类型ID
	private float currPrice;//会员价
	private String fname; //食品名
	private String food_desp;//描述
	private int foodId; //食品id 主键 自增
	private String image; //存储图片路径（名）
	private String material;//配料
	private float price; //市场价格
	private int quantity1;//市场销售数量
	public Food() {
		super();
	}
	public Food(int foodId, String fname, float price, float currPrice, String material, String food_desp, Type type,
			String image, int quantity1) {
		super();
		this.foodId = foodId;
		this.fname = fname;
		this.price = price;
		this.currPrice = currPrice;
		this.material = material;
		this.food_desp = food_desp;
		this.type = type;
		this.image = image;
		this.quantity1 = quantity1;
	}
	//	public Food(int foodId, String fname, float price, float currPrice, String material, String food_desp, int cid,
//			String image, int quantity1) {
//		super();
//		this.foodId = foodId;
//		this.fname = fname;
//		this.price = price;
//		this.currPrice = currPrice;
//		this.material = material;
//		this.food_desp = food_desp;
//		this.cid = cid;
//		this.image = image;
//		this.quantity1 = quantity1;
//	}
//	public int getCid() {
//		return cid;
//	}
	public float getCurrPrice() {
		return currPrice;
	}
	public String getFname() {
		return fname;
	}
	public String getFood_desp() {
		return food_desp;
	}
	public int getFoodId() {
		return foodId;
	}
	public String getImage() {
		return image;
	}
	public String getMaterial() {
		return material;
	}
	public float getPrice() {
		return price;
	}
	public int getQuantity1() {
		return quantity1;
	}
//	public void setCid(int cid) {
//		this.cid = cid;
//	}
	public void setCurrPrice(float currPrice) {
		this.currPrice = currPrice;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setFood_desp(String food_desp) {
		this.food_desp = food_desp;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setQuantity1(int quantity1) {
		this.quantity1 = quantity1;
	}
//	@Override
//	public String toString() {
//		return "Food [foodId=" + foodId + ", fname=" + fname + ", price=" + price + ", currPrice=" + currPrice
//				+ ", material=" + material + ", food_desp=" + food_desp + ", cid=" + cid + ", image=" + image
//				+ ", quantity1=" + quantity1 + "]";
//	}
	
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Food [type=" + type + ", currPrice=" + currPrice + ", fname=" + fname + ", food_desp=" + food_desp
				+ ", foodId=" + foodId + ", image=" + image + ", material=" + material + ", price=" + price
				+ ", quantity1=" + quantity1 + "]";
	}
//	public Food(Type type, float currPrice, String fname, String food_desp, int foodId, String image, String material,
//			float price, int quantity1) {
//		super();
//		this.type = type;
//		this.currPrice = currPrice;
//		this.fname = fname;
//		this.food_desp = food_desp;
//		this.foodId = foodId;
//		this.image = image;
//		this.material = material;
//		this.price = price;
//		this.quantity1 = quantity1;
//	}
	
	
}
