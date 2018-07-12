package com.food.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.Cartitem;
import com.food.bean.Food;
import com.food.bean.Message;
import com.food.bean.Order;
import com.food.bean.User;
import com.food.service.CartService;
import com.food.service.FoodService;
import com.food.service.OrderService;
import com.food.serviceImpl.CartServiceImpl;
import com.food.serviceImpl.FoodServiceImpl;
import com.food.serviceImpl.OrderServiceImpl;
import com.food.utils.DefaultServlet;
import com.food.utils.PageBean;

/**
 * Servlet implementation class FoodServlet
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends DefaultServlet {
	private static final long serialVersionUID = -3664660949902021176L;
	
	private FoodService foodService = new FoodServiceImpl(); 
	private CartService cartService = new CartServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	
	/**
	 * 获取页面数据
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String getFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("页面信息");
		/*
		 * 1. 得到pc：如果页面传递使用页面的，否则pc=1
		 */
		int pc = getPc(request);
		System.out.println(pc);
		/*
		 * 2. 得到url：xxx
		 */
		String url = getUrl(request);
		System.out.println(url);
		
		PageBean<Food> pb = foodService.getByPage(pc);
		PageBean<Message> mess = foodService.getMessage();
		/*
		 * 3. 给PageBean设置url，保存PageBean，转发到/forgound/index.jsp
		 */
		pb.setUrl(url);
		/*
		 * 4.判断用户是否登录以显示餐车信息
		 */
		User user = (User)request.getSession().getAttribute("userSession");
		if(user!=null) {
			request.setAttribute("itemList", getCartItem(user.getUserId()));
		}
		
		List<Order> sales = orderService.getSale();
		if(sales != null) {
			request.setAttribute("sales", sales);
		}
		System.out.println(pb);
//		List<Food> foods = foodService.getAll();
//		System.out.println(foods.size());
		
		request.setAttribute("foods", pb);
		request.setAttribute("message", mess);
		return "f:/forgound/index.jsp";
	}
	
	
	/**
	 * 得到pc 当前页码
	 * @param request
	 * @return
	 */
	private int getPc(HttpServletRequest request){
		int pc = 1;
		String param = request.getParameter("pc");
		if(param != null && !param.trim().isEmpty()){
			try {
				pc = Integer.parseInt(param);
			} catch (RuntimeException e) {}
		}
		return pc;
	}
	
	/**
	 * 截取url,页面中的分页导航中需要使用它作为超链接的目标
	 * @param request
	 * @return
	 */
	private String getUrl(HttpServletRequest request){
		String url = request.getRequestURI() + "?" + request.getQueryString();
		/*
		 * 如果url中存在pc参数，截取掉，如果不存在那就不用截取
		 */
		int index = url.lastIndexOf("&pc=");
		if(index != -1) {
			url = url.substring(0, index);
		}
		return url;
	}
	
	/**
	 * 通过userId查询获得对应用户的餐车信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private List<Cartitem> getCartItem(int userId) throws ServletException, IOException {
		PageBean<Cartitem> itemList = cartService.getItem(userId);
		return  itemList.getBeanList();
	}
}
