package com.food.bean;

public class Test {
	private static void test(Object object){
		System.out.println(object.getClass().getName());
	}
	public static void main(String[] args) {
		Food food=new Food();
		System.out.println(Food.class.getName());
	}
}
