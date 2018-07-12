package com.food.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.bean.Admin;
import com.food.service.AdminService;
import com.food.serviceImpl.AdminServiceImpl;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private AdminService adminService=new AdminServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/background/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("loginname");
		String password=request.getParameter("password");
		Admin admin=new Admin(0,name,password);
		boolean flag= adminService.adminExist(admin);
		if (flag) {  //合法用户
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(900);
			session.setAttribute("admin", admin);
			session.setAttribute("convertType", adminService.convertType());
			System.out.println(adminService.convertType().getMap());
			request.getRequestDispatcher("/background/background.jsp").forward(request, response);
		}else {  //非法用户
			response.setCharacterEncoding("gb2312");
			PrintWriter out=response.getWriter();
			out.write("<script>alert('用户名或密码错误！'); window.location.assign('/Food/AdminServlet') </script>");
		}
		
	}

}
