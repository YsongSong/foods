package com.food.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.Cartitem;
import com.food.bean.Order;
import com.food.bean.User;
import com.food.service.CartService;
import com.food.service.OrderService;
import com.food.serviceImpl.CartServiceImpl;
import com.food.serviceImpl.OrderServiceImpl;
import com.food.utils.DefaultServlet;
import com.food.utils.PageBean;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends DefaultServlet {
	private static final long serialVersionUID = 1L;
	
	private CartService cartService = new CartServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	
	public String createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 获取用户餐车所有数据
		 */
//		String foodId = request.getParameter("foodId");
//		User user = (User) request.getSession().getAttribute("userSession");
//		Cartitem cartitem = new Cartitem();
//		Food food = new Food();
//		food.setFoodId(Integer.parseInt(foodId));
//		cartitem.setFood(food);
//		cartitem.setUserId(user.getUserId());
//		cartService.add(cartitem); //添加
		User user = (User) request.getSession().getAttribute("userSession");
		System.out.println(getCartItem(user.getUserId()));
		
		PageBean<Cartitem> pb = getCartItem(user.getUserId());
		List<Cartitem> carts = pb.getBeanList();
		/* 添加订单信息  并完成订单创建 */
		for(Cartitem cartitem : carts) {
			Order order = new Order();
			order.setFood(cartitem.getFood());
			order.setOrdertime(String.format("%tF %<tT", new Date()));
			order.setQuantity(cartitem.getQuantity());
			order.setStatus(0);
			order.setTotal(cartitem.getQuantity()*cartitem.getFood().getCurrPrice());
			order.setUser(user);
			orderService.createOrder(order);  //调用service完成添加并清空餐车
		}
		return getOrderByUserId(request, response);
	}
	
	/**
	 * 获得所有订单信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> orderList = orderService.getOrder();
		request.setAttribute("orderList", orderList);
		return "f:/forground/order.jsp";
	}
	
	/**
	 * 按用户Id查询订单信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getOrderByUserId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("userSession");
		int userId = user.getUserId();
		List<Order> orderList =  orderService.getOrderByUserId(userId);
		request.setAttribute("orderList", orderList);
		return "f:/forgound/order.jsp";
	}
	
	/**
	 * 根据Id订单数据显示
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getOrderByUserId1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("userSession");
		int userId = user.getUserId();
		List<Order> orderList =  orderService.getOrderByUserId(userId);
		request.setAttribute("orderList", orderList);
		return "f:/forgound/order.jsp";
	}
	
	/**
	 * 根据时间订单数据显示
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getOrderTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("userSession");
//		int userId = user.getUserId();
		String ordertime=request.getParameter("ordertime");
		List<Order> orderList = orderService.getOrderByTime(2, ordertime);
		request.setAttribute("orderList", orderList);
		return "f:/forgound/order.jsp";
	}
	/**
	 * 根据菜名订单数据显示
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getOrderFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("userSession");
		int userId = user.getUserId();
		String foodname=request.getParameter("foodname");
		List<Order> orderList =  orderService.getOrderByFood(userId, foodname);
		request.setAttribute("orderList", orderList);
		return "f:/forgound/order.jsp";
	}
	/**
	 * 根据状态订单数据显示
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getOrderStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("userSession");
		int userId = user.getUserId();
		String status=request.getParameter("status");
		List<Order> orderList = orderService.getOrderByStatus(userId, Integer.parseInt(status));
		request.setAttribute("orderList", orderList);
		return "f:/forgound/order.jsp";
	}
	
	
	
	
	/**
	 * 获得今天所有订单数据，进行销售统计
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getSaleList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageBean<Order> orderList = orderService.getSaleList();
		request.setAttribute("saleList", orderList);
		return "f:/background/saleList.jsp";
	}
	
	
	/**
	 * 通过userId查询获得对应用户的餐车信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public PageBean<Cartitem> getCartItem(int userId) {
//		User user = (User) request.getSession().getAttribute("userSession");
//		int userId = user.getUserId();
		PageBean<Cartitem> itemList = cartService.getItem(userId);
		System.out.println(itemList);
		return itemList;
	}

}
