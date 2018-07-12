package com.food.bean;

public class Dish {
	private String district; //地区
	private String foodName; //食物名
	private int id;
	private String level;    //热度
	private String src;      //图片路径
	public Dish() {
		super();
	}
	public Dish(int id, String district, String foodName, String level, String src) {
		super();
		this.id = id;
		this.district = district;
		this.foodName = foodName;
		this.level = level;
		this.src = src;
	}
	public Dish(String district, String foodName, String level, String src) {
		super();
		this.district = district;
		this.foodName = foodName;
		this.level = level;
		this.src = src;
	}
	public String getDistrict() {
		return district;
	}
	public String getFoodName() {
		return foodName;
	}
	public int getId() {
		return id;
	}
	public String getLevel() {
		return level;
	}
	public String getSrc() {
		return src;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	@Override
	public String toString() {
		return "Dish [id=" + id + ", district=" + district + ", foodName=" + foodName + ", level=" + level + ", src="
				+ src + "]";
	}
	
}
