package com.food.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.Cartitem;
import com.food.bean.Food;
import com.food.bean.User;
import com.food.service.CartService;
import com.food.serviceImpl.CartServiceImpl;
import com.food.utils.DefaultServlet;
import com.food.utils.PageBean;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends DefaultServlet {
	private static final long serialVersionUID = 1L;
	
	private CartService cartService = new CartServiceImpl();
       
	/**
	 * 添加餐车信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 封装表单数据到
		 */
		String foodId = request.getParameter("foodId");
		User user = (User) request.getSession().getAttribute("userSession");
		Cartitem cartitem = new Cartitem();
		Food food = new Food();
		food.setFoodId(Integer.parseInt(foodId));
		cartitem.setFood(food);
		cartitem.setUserId(user.getUserId());
		cartService.add(cartitem); //添加
		return "r:/index.jsp";
	}
	
	/**
	 * 通过userId查询获得对应用户的餐车信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("userSession");
		int userId = user.getUserId();
		PageBean<Cartitem> itemList = cartService.getItem(userId);
		request.setAttribute("itemList", itemList);
		return "f:/forgound/canche.jsp";
	}
	
	public String deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("userSession");
		cartService.deleteAll(user.getUserId());
		return "f:/index.jsp";
	}

}
