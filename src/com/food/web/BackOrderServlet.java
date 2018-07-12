package com.food.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.Cartitem;
import com.food.bean.Order;
import com.food.service.BackOrderService;
import com.food.service.CartService;
import com.food.serviceImpl.BackOrderServiceImpl;
import com.food.serviceImpl.CartServiceImpl;
import com.food.utils.DefaultServlet;
import com.food.utils.PageBean;
import com.food.utils.StringUtil;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/BackOrderServlet")
public class BackOrderServlet extends DefaultServlet {
	private static final long serialVersionUID = 1L;
	
	private CartService cartService = new CartServiceImpl();
	private BackOrderService orderService = new BackOrderServiceImpl();
	
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
		return "f:/background/order.jsp";
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
		String userId = request.getParameter("userId");
		if(StringUtil.isEmpty(userId)) {
			List<Order> orderList = orderService.getOrder();
			request.setAttribute("orderList", orderList);
		} else {
			List<Order> orderList = orderService.getOrderByUserId(Integer.parseInt(userId));
			request.setAttribute("orderList", orderList);
		}
		return "f:/background/orderquery.jsp";
	}
	
	
	/**
	 * 按菜名查询订单信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getOrderByFoodName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String foodName = request.getParameter("foodName");
		if(StringUtil.isEmpty(foodName)) {
			List<Order> orderList = orderService.getOrder();
			request.setAttribute("orderList", orderList);
		} else {
			List<Order> orderList = orderService.getOrderByFood(foodName);
			request.setAttribute("orderList", orderList);
		}
		return "f:/background/orderquery.jsp";
	}
	
	/**
	 * 按日期查询订单信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getOrderByOrderTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ordertime = request.getParameter("ordertime");
		if(StringUtil.isEmpty(ordertime)) {
			List<Order> orderList = orderService.getOrder();
			request.setAttribute("orderList", orderList);
		} else {
			List<Order> orderList = orderService.getOrderByTime(ordertime);
			request.setAttribute("orderList", orderList);
		}
		return "f:/background/orderquery.jsp";
	}
	
	
	/**
	 * 确认订单(派送)
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String sureOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		orderService.sureOrder(Integer.parseInt(orderId));	//确认订单
		return getOrder(request, response);
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
		PageBean<Order> pb = orderService.getSaleList();
		request.setAttribute("saleList", pb);
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
