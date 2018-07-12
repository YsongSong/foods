package com.food.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.Admin;
import com.food.service.AdminLoginService;
import com.food.serviceImpl.AdminLoginServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private AdminLoginService adminLoginService=new AdminLoginServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String index=request.getParameter("index");
		switch (index) {
		case "info":
			Admin admin=(Admin) request.getSession().getAttribute("admin");
			System.out.println(admin+"-----1----");
			Admin t=adminLoginService.getAdmin(admin).get(0);
			System.out.println(t+"-----2----");
			request.setAttribute("admin", t);
			request.getRequestDispatcher("/background/adminInfo.jsp").forward(request, response);
			break;
		case "logout":
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			adminLoginService.logout(request);
			out.write("<script>window.location.assign('/Food/AdminServlet') </script>");
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tid=request.getParameter("id");
		int id=Integer.parseInt(tid);
		String adminName=request.getParameter("adminName");
		String adminPwd=request.getParameter("adminPwd");
		Admin admin=new Admin(id, adminName, adminPwd);
		System.out.println(admin+"-----3----");
		boolean flag=adminLoginService.changeInfo(admin);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		if (flag) {
			request.getSession().removeAttribute("admin");
			request.getSession().setAttribute("admin", admin);
			out.write("<script>alert('更改成功！！'); window.location.assign('/Food/LogoutServlet?index=info') </script>");
		}else {
			out.write("<script>alert('更改失败！！'); window.location.assign('/Food/LogoutServlet?index=info') </script>");
		}
	}

}
