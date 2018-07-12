package com.food.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.food.bean.Food;
import com.food.bean.Type;
import com.food.dao.FoodDao;
import com.food.utils.ConvertUtils;
import com.food.utils.DBUtils;
import com.food.utils.PageBean;
import com.food.utils.PageConstants;

public class FoodDaoImpl implements FoodDao {

	@Override
	public List<Food> findByCondition(String sql, List<Object> param) {
		List<Map<String, Object>> list= DBUtils.executeQuery(sql, param);
		return (List<Food>) ConvertUtils.convert(list, Food.class);
	}

	@Override
	public boolean insertFood(String sql, List<Object> param) {
		
		return DBUtils.executeUpdate(sql, param);
	}

	@Override
	public boolean insertFoodType(String sql, List<Object> param) {
		return DBUtils.executeUpdate(sql, param);
	}

	@Override
	public boolean delete(String sql, List<Object> param) {
		return DBUtils.executeUpdate(sql, param);
	}

	@Override
	public boolean update(String sql, List<Object> param) {
		return DBUtils.executeUpdate(sql, param);
	}

	@Override
	public List<Type> findFoodType(String sql, List<Object> param) {
		List<Map<String, Object>> list= DBUtils.executeQuery(sql, param);
		return (List<Type>) ConvertUtils.convert(list, Type.class);
	}

	@Override
	public List<Type> findType(String sql, List<Object> param) {
		List<Map<String, Object>> list= DBUtils.executeQuery(sql, param);
		return (List<Type>) ConvertUtils.convert(list, Type.class);
	}
	
	@Override
	public PageBean<Food> findByPage(int pc) {
		/*
		 * 1. 得到ps(每页记录数)
		 * 2. 得到tr(总记录数)
		 * 3. 得到beeanList
		 * 4. 创建PageBean，返回
		 */
		
		/*
		 * 1. 得到ps
		 */
		int ps = PageConstants.BOOK_PAGE_SIZE;//每页记录数
		/*
		 * 3. 得到tr(总记录数)
		 * select * from t_book
		 */
		String sql = "select * from t_food";
		List<Food> list = findByCondition(sql,null);
		int tr = list.size();
		System.out.println(tr);
		/*
		 * 4. 得到beanList,即当前页记录
		 */
		//SELECT * FROM t_food t,t_kind k WHERE t.cid=k.cid ORDER BY foodId LIMIT 0,6 
		sql = "select * from t_food t,t_kind k where t.cid=k.cid order by foodId limit ?,?";
		List<Object> param = new ArrayList<>();
		
		param.add((pc-1)*ps);//当前页首行记录下标    当前页(ps)-1*每页记录数(ps)
		param.add(ps);//一共查询几行，即每页记录数
		List<Food> foods = findByCondition(sql,param);
		/*
		 * 5. 创建PageBean,设置参数
		 */
		PageBean<Food> pb = new PageBean<Food>();
		/*
		 * 其中PageBean没有url，这个任务由Servlet完成
		 */
		int tp = tr/ps;
		tp = tr % ps == 0 ? tp :tp + 1; 
		
		pb.setBeanList(foods);
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);
		pb.setTp(tp);
		return pb;
	}

}
