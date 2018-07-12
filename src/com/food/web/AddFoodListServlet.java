package com.food.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.food.bean.Food;
import com.food.bean.Type;
import com.food.service.AdminService;
import com.food.serviceImpl.AdminServiceImpl;
import com.food.utils.TypeConvert;
@WebServlet("/AddFoodListServlet")
@MultipartConfig
public class AddFoodListServlet extends HttpServlet {
	private static final long serialVersionUID = -5257279805846635795L;
	
	private AdminService adminService=new AdminServiceImpl();

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    TypeConvert convertType=(TypeConvert) request.getSession().getAttribute("convertType");
		request.getRequestDispatcher("/background/addMenu.jsp").forward(request, response);
	}


	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date=new Date();
		String dateBase=date.getYear()+"_"+date.getMonth()+"_"+date.getDay()+"_"+date.getHours()+"_"+date.getMinutes()+"_"+date.getSeconds();
		request.setCharacterEncoding("UTF-8");
		String fname=request.getParameter("fname");
		float price=Float.parseFloat(request.getParameter("price"));
		float currPrice=Float.parseFloat(request.getParameter("currPrice"));
		String material=request.getParameter("material");
		String food_desp=request.getParameter("food_desp");
		int cid=Integer.parseInt(request.getParameter("cid"));
		String base=request.getServletContext().getRealPath("upload");
		File file=new File(base);
		if (!file.exists()) {
			file.mkdir();
		}
		Part part=request.getPart("image");
		String filePath=base+"\\"+dateBase+"_"+part.getSubmittedFileName();
		part.write(filePath);
		String image="upload\\"+dateBase+"_"+part.getSubmittedFileName();  //图片路径
		Food food=new Food(0, fname, price, currPrice, material, food_desp, new Type(cid,null), image, 0);
		System.out.println(food);
		boolean flag=adminService.insertFood(food);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		if (flag) {
			out.write("<script>alert('添加成功！'); window.location.assign('/Food/AddFoodListServlet') </script>");
		}else {
			out.write("<script>alert('添加失败！'); window.location.assign('/Food/AddFoodListServlet') </script>");
		}
	}

}
