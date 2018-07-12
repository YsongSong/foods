package com.food.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.food.bean.Admin;
import com.food.bean.Food;
import com.food.bean.Type;
import com.food.dao.FoodDao;
import com.food.dao.UserDao;
import com.food.daoImpl.FoodDaoImpl;
import com.food.daoImpl.UserDaoImpl;
import com.food.service.AdminService;
import com.food.utils.TypeConvert;

public class AdminServiceImpl implements AdminService {
	private UserDao userDao=new UserDaoImpl();
	private FoodDao foodDao=new FoodDaoImpl();

	
	/* 
	 * 查询是否为合法用户
	 * @see com.food.service.AdminService#adminExist(com.food.bean.Admin)
	 */
	@Override
	public boolean adminExist(Admin admin) {
		String sql="select * from t_admin WHERE adminName=? and adminPwd=?";
		List<Object> param=new ArrayList<>();
		param.add(admin.getAdminName());
		param.add(admin.getAdminPwd());
		List<Admin> list=userDao.findAdmin(sql, param);
		return list.size()==1?true:false;
	}


	@Override
	public TypeConvert convertType() {
		Map<Integer, String> map=new HashMap<>();
		String sql="select * from t_kind";
		List<Type> list=foodDao.findFoodType(sql, null);
		for (Type type : list) {
			map.put(type.getCid(),type.getCidName());
		}
		TypeConvert typeConvert=TypeConvert.getTypeConvert();
		typeConvert.setMap(map);
		return typeConvert;
	}


	@Override
	public boolean insertFood(Food food) {
		String sql="insert into t_food(fname,price,currPrice,material,food_desp,cid,image,quantity1)values(?,?,?,?,?,?,?,?)";
		List<Object> param=new ArrayList<>();
		param.add(food.getFname());
		param.add(food.getPrice());
		param.add(food.getCurrPrice());
		param.add(food.getMaterial());
		param.add(food.getFood_desp());
		param.add(food.getType().getCid());
		param.add(food.getImage());
		param.add(food.getQuantity1());
		boolean flag=foodDao.insertFood(sql, param);
		return flag;
	}


	@Override
	public List<Food> getFoodList() {
		String sql="select * from t_food";
		List<Food> foods=foodDao.findByCondition(sql, null);
		return foods;
	}


	@Override
	public boolean updateFood(Food food) {
		String sql="update t_food set fname=?,price=?,currPrice=?,material=?,food_desp=?,cid=?,quantity1=? where foodId=?";
		List<Object> param=new ArrayList<>();
		param.add(food.getFname());
		param.add(food.getPrice());
		param.add(food.getCurrPrice());
		param.add(food.getMaterial());
		param.add(food.getFood_desp());
		param.add(food.getType().getCid());
		param.add(food.getQuantity1());
		param.add(food.getFoodId());
		boolean flag=foodDao.insertFood(sql, param);
		return flag;
	}


	@Override
	public Food getFood(int foodId) {
		String sql="select * from t_food where foodId=?";
		List<Object> param=new ArrayList<>();
		param.add(foodId);
		List<Food> food=foodDao.findByCondition(sql, param);
		return food.get(0);
	}


	@Override
	public boolean deleteFood(int foodId) {
		String sql="delete from t_food where foodId=?";
		List<Object> param=new ArrayList<>();
		param.add(foodId);
		return foodDao.delete(sql, param);
	}


	@Override
	public boolean addType(Type type) {
		String sql="insert into t_kind(cidName) values(?)";
		List<Object> param=new ArrayList<>();
		param.add(type.getCidName());
		return foodDao.insertFood(sql, param);
	}


	@Override
	public List<Type> getTypes(Type type) {
		String sql="";
		List<Object> param=null;
		if (type==null) {
			sql="select * from t_kind";
		}else if (type.getCidName().length()==0){
			sql="select * from t_kind where cid=?";
			param=new ArrayList<>();
			param.add(type.getCid());
		}else {
			sql="select * from t_kind where cidName=?";
			param=new ArrayList<>();
			param.add(type.getCidName());
		}
		return foodDao.findType(sql, param);
	}


	@Override
	public boolean updateType(Type type) {
		String sql="update t_kind set cidName=? where cid=?";
		List<Object> param=new ArrayList<>();
		param.add(type.getCidName());
		param.add(type.getCid());
		return foodDao.update(sql, param);
	}


	@Override
	public boolean deleteType(Type type) {
		String sql="delete from t_kind  where cid=?";
		List<Object> param=new ArrayList<>();
		param.add(type.getCid());
		return foodDao.delete(sql, param);
	}

}
