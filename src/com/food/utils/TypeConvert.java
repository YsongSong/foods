package com.food.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *单例，类中map保存菜类型与id的映射
 */
public class TypeConvert {
	private static TypeConvert typeConvert=new TypeConvert();
	private Map<Integer, String> map=new HashMap<>();
	private TypeConvert(){}
	public static TypeConvert getTypeConvert(){
		return typeConvert;
	}
	public Map<Integer, String> getMap() {
		return map;
	}
	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}
}
