package com.food.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.food.bean.Admin;
import com.food.bean.Cartitem;
import com.food.bean.Dish;
import com.food.bean.Food;
import com.food.bean.HDFS;
import com.food.bean.Message;
import com.food.bean.Order;
import com.food.bean.Type;
import com.food.bean.User;
public class ConvertUtils {
	public static Object convert(List<Map<String, Object>> list,Class T){
		switch (T.getName()) {
		case "com.food.bean.Admin":
			return getAdmin(list);
		case "com.food.bean.Cartitem":
			return getCartitem(list);
		case "com.food.bean.Food":
			return getFood(list);
		case "com.food.bean.Message":
			return getMessage(list);
		case "com.food.bean.Order":
			return getOrder(list);
		case "com.food.bean.Type":
			return getType(list);
		case "com.food.bean.User":
			return getUser(list);
		case "com.food.bean.HDFS":
			return getHDFS(list);
		case "com.food.bean.Dish":
			return getDishs(list);
		}
		
		return null;
	}

	private static List<Dish> getDishs(List<Map<String, Object>> list){
		List<Dish> dishs=new ArrayList<>();
		for (Map<String, Object> map : list) {
			Dish temp=new Dish();
			temp.setId(Integer.parseInt(""+map.get("id")));
			temp.setDistrict(""+map.get("district"));
			temp.setFoodName(""+map.get("foodName"));
			temp.setLevel(""+map.get("level"));
			temp.setSrc(""+map.get("src"));
			dishs.add(temp);
		}
		return dishs;
	}
	
	private static List<HDFS> getHDFS(List<Map<String, Object>> list){
		List<HDFS> hdfs=new ArrayList<>();
		for (Map<String, Object> map : list) {
			HDFS temp=new HDFS();
			temp.setHid(Integer.parseInt(""+map.get("hid")));
			temp.setFileName(""+map.get("filename"));
			temp.setFilepath(""+map.get("filepath"));
			hdfs.add(temp);
		}
		return hdfs;
	}

	private static List<Admin> getAdmin(List<Map<String, Object>> list){
		List<Admin> admin=new ArrayList<>();
		for (Map<String, Object> map : list) {
			Admin temp=new Admin();
			if(map.get("id")!=null) {
				System.out.println(map.get("id"));
				temp.setId(Integer.parseInt(map.get("id")+""));
			}
			temp.setAdminPwd((String)map.get("adminPwd"));
			temp.setAdminName((String)map.get("adminName"));
			admin.add(temp);
		}
		return admin;
	}
	private static List<Cartitem> getCartitem(List<Map<String, Object>> list){
		List<Cartitem> cartitem=new ArrayList<>();
		for (Map<String, Object> map : list) {
			Cartitem temp=new Cartitem();
			
			if(map.get("foodId")!=null && map.get("currPrice")!=null && map.get("fname")!=null) {
				Food food = new Food();
				food.setFoodId((int)map.get("foodId"));
				food.setCurrPrice(Float.parseFloat(""+map.get("currPrice")));
				food.setFname((String)map.get("fname"));
				temp.setFood(food);
			}
			if(map.get("total")!=null) {
				temp.setTotal(Integer.parseInt(""+map.get("total")));
			}
			if(map.get("subtotal")!=null) {
				temp.setSubtotal(Float.parseFloat(""+map.get("subtotal")));
			}
			if(map.get("cartitemId")!=null) {
				temp.setCartitemId(Integer.parseInt(""+map.get("cartitemId")));
			}
//			temp.setFoodId(Integer.parseInt(""+map.get("foodId")));
			if(map.get("quantity")!=null) {
				temp.setQuantity(Integer.parseInt(""+map.get("quantity"))); 
			}
			if(map.get("userId")!=null) {
				temp.setUserId(Integer.parseInt(""+map.get("userId"))); 
			}
			cartitem.add(temp);
		}
		return cartitem;
	}
	private static List<Food> getFood(List<Map<String, Object>> list){
		List<Food> food=new ArrayList<>();
		for (Map<String, Object> map : list) {
			Food temp=new Food();
			
			int cid = (int) map.get("cid");
			String cidname = (String) map.get("cidName");
			temp.setType(new Type(cid,cidname)); 
			
//			temp.setCid(Integer.parseInt(""+map.get("cid"))); 
			temp.setCurrPrice(Float.parseFloat(""+ map.get("currPrice")));
			temp.setFname(( String)map.get("fname"));
			temp.setFood_desp((String)map.get("food_desp") );
			temp.setFoodId(Integer.parseInt(""+map.get("foodId")));
			temp.setImage((String)map.get("image"));
			temp.setMaterial((String)map.get("material") );
			temp.setPrice(Float.parseFloat(""+map.get("price")));
			temp.setQuantity1(Integer.parseInt(""+map.get("quantity1"))); 
			food.add(temp);
		}
		return food;
	}
	private static List<Message> getMessage(List<Map<String, Object>> list){
		List<Message> message=new ArrayList<>();
		for (Map<String, Object> map : list) {
			Message temp=new Message();
			temp.setDetail((String)map.get("detail") );
			temp.setMessdate((String)map.get("messdate"));
			temp.setMid(Integer.parseInt(""+map.get("mid"))); 
			temp.setTitle((String)map.get("title"));
			message.add(temp);
		}
		return message;

	}
	private static List<Order> getOrder(List<Map<String, Object>> list){
		List<Order> order=new ArrayList<>();
		for (Map<String, Object> map : list) {
			Order temp=new Order();
//			temp.setFoodId(Integer.parseInt(""+map.get("foodId")));
			if(map.get("oderId")!=null) {
				temp.setOderId(Integer.parseInt(""+map.get("oderId"))); 
			}
			temp.setOrdertime((String)map.get("ordertime"));
			if(map.get("quantity")!=null) {
				temp.setQuantity(Integer.parseInt(""+map.get("quantity")));
			}
			if(map.get("status")!=null) {
				temp.setStatus(Integer.parseInt(""+map.get("status")));
			}
			if(map.get("total")!=null) {
				temp.setTotal(Float.parseFloat(""+map.get("total")));
			}
//			temp.setUserId(Integer.parseInt(""+map.get("userId")));
			Food food = new Food();
			if(map.get("foodId")!=null) {
				food.setFoodId((int)map.get("foodId"));
			}
			if(map.get("currPrice")!=null) {
				food.setCurrPrice(Float.parseFloat(""+map.get("currPrice")));
			}
			food.setFname((String)map.get("fname"));
			temp.setFood(food);
			
			if(map.get("userId")!=null&&map.get("userName")!=null&&map.get("userAddress")!=null&&map.get("userPhone")!=null) {
				User user = new User();
				user.setUserId(Integer.parseInt(""+map.get("userId")));
				user.setUserName(""+map.get("userName"));
				user.setUserAddress(""+map.get("userAddress"));
				user.setUserPhone(""+map.get("userPhone"));
				temp.setUser(user);
			}
			
			order.add(temp);
		}
		return order;
	}
	private static List<Type> getType(List<Map<String, Object>> list){
		List<Type> type=new ArrayList<>();
		for (Map<String, Object> map : list) {
			Type temp=new Type();
			temp.setCid(Integer.parseInt(""+map.get("cid")));
			temp.setCidName((String)map.get("cidName"));
			type.add(temp);
		}
		return type;
	}
	private static List<User> getUser(List<Map<String, Object>> list){
		List<User> user=new ArrayList<>();
		for (Map<String, Object> map : list) {
			User temp=new User();
			temp.setUserAddress((String)map.get("userAddress"));
			temp.setUserAge(Integer.parseInt(""+map.get("userAge")));
			temp.setUserEmail((String)map.get("userEmail")+"");
			temp.setUserId(Integer.parseInt(""+map.get("userId")));
			temp.setUserName((String)map.get("userName"));
			temp.setUserNum(map.get("userNum")+"");
			temp.setUserPhone(map.get("userPhone")+"");
			if(map.get("userPostNum")!=null) {
				temp.setUserPostNum(map.get("userPostNum")+"");
			}
			temp.setUserPwd((String)map.get("userPwd"));
			temp.setUserSex((String)map.get("userSex"));
			user.add(temp);
		}
		return user;
	}

}
