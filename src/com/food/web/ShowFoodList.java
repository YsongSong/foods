package com.food.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.bean.Food;
import com.food.bean.Type;
import com.food.service.AdminService;
import com.food.serviceImpl.AdminServiceImpl;
import com.food.utils.TypeConvert;
/**
 * Servlet implementation class ShowFoodList
 */
@WebServlet("/ShowFoodList")
public class ShowFoodList extends HttpServlet {
	private AdminService adminService=new AdminServiceImpl();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String index=request.getParameter("index");
		String foodId=request.getParameter("foodId");
		int id=0;
		if (foodId!=null&&foodId.length()>0) {
			id=Integer.parseInt(foodId);
		}
		System.out.println("访问……"+index);
		String target="";
		switch (index) {
		case "find":
			target="/background/foodList.jsp";
			List<Food> foods=adminService.getFoodList();
			HttpSession session=request.getSession();
			TypeConvert convertType=(TypeConvert)session.getAttribute("convertType");
			System.out.println(convertType.getMap());
			System.out.println(foods);
			request.setAttribute("foods", foods);
			request.getRequestDispatcher(target).forward(request, response);
			break;
		case "update":
			target="/background/updateFood.jsp";
			Food food=adminService.getFood(id);
			System.out.println(food);
			request.setAttribute("food", food);
			request.getRequestDispatcher(target).forward(request, response);
			break;
		case "delete":
			target="/background/foodList.jsp";
			boolean t=adminService.deleteFood(id);
			if (t) {
				System.out.println("删除成功……");
				out.write("<script>alert('删除成功！'); window.location.assign('/Food/ShowFoodList?index=find') </script>");
			}else {
				out.write("<script>alert('删除失败！'); window.location.assign('/Food/ShowFoodList?index=find') </script>");
			}
			break;

		default:
			target="/background/foodList.jsp";
			request.getRequestDispatcher(target).forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("修改……");
		request.setCharacterEncoding("UTF-8");
		String foodId=request.getParameter("foodId");
		int id=Integer.parseInt(foodId);
		String fname=request.getParameter("fname");
		float price=Float.parseFloat(request.getParameter("price"));
		float currPrice=Float.parseFloat(request.getParameter("currPrice"));
		String material=request.getParameter("material");
		String food_desp=request.getParameter("food_desp");
		int cid=Integer.parseInt(request.getParameter("cid"));
		Food food=new Food(id, fname, price, currPrice, material, food_desp,new Type(cid,null),"", 0);
		boolean flag=adminService.updateFood(food);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		if (flag) {
			out.write("<script>alert('修改成功！'); window.location.assign('/Food/ShowFoodList?index=find') </script>");
		}else {
			out.write("<script>alert('修改失败！'); window.location.assign('/Food/ShowFoodList?index=find') </script>");
		}
		
	}

}
