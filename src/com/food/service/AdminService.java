package com.food.service;

import java.util.List;

import com.food.bean.Admin;
import com.food.bean.Food;
import com.food.bean.Type;
import com.food.utils.TypeConvert;

public interface AdminService {
	/**
	 * 判断是否合法用户
	 * @param admin
	 * @return
	 */
	public boolean adminExist(Admin admin);
	
	/**
	 * 获取菜品类型转换对象
	 * @return
	 */
	public TypeConvert convertType();
	
	public boolean insertFood(Food food);
	
	public List<Food> getFoodList();
	
	public boolean updateFood(Food food);
	
	public Food getFood(int foodId);
	
	public boolean deleteFood(int foodId);
	
	public boolean addType(Type type);
	
	public List<Type> getTypes(Type type);
	
	
	public boolean updateType(Type type);

	public boolean deleteType(Type type);
	
}
