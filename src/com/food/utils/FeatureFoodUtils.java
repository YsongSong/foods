package com.food.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.food.bean.Dish;

public class FeatureFoodUtils {
	private static List<Dish> getDishes(String path){
		List<Dish> dishs=new ArrayList<>();
		File file=new File(path);
		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String temp="";
			while((temp=reader.readLine())!=null){
				String ao[]=temp.split("[\\p{Blank}\\|]");
				Dish dish=new Dish();
				dish.setDistrict(ao[0]);
				dish.setFoodName(ao[1]);
				dish.setLevel(ao[2]);
				dish.setSrc(ao[3]);
				dishs.add(dish);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(dishs);
		return dishs;

	}
	private static void saveToDB(String path){
		List<Dish> list=getDishes(path);
		String sql="INSERT into t_dish(district,foodName,level,src) values(?,?,?,?)";
		for (Dish dish : list) {
			List<Object> param=new ArrayList<>();
			param.add(dish.getDistrict());
			param.add(dish.getFoodName());
			param.add(dish.getLevel());
			param.add(dish.getSrc());
			DBUtils.executeUpdate(sql, param);
		}
	}
	public static void main(String[] args) {
		String path="C:\\Users\\Administrator\\Desktop\\Food\\src\\com\\food\\utils\\res.txt";
		saveToDB(path);
	}
}
