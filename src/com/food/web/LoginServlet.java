package com.food.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.User;
import com.food.dao.UserDao;
import com.food.daoImpl.UserDaoImpl;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");;
		//调用业务层
		UserDao UserDao=new UserDaoImpl();
	
		String userName=request.getParameter("userName");
		String userPwd=request.getParameter("userPwd");
		
		User user=new User();
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		
		String sql="select * from user where userName=? and userPwd=?";
		ArrayList<Object>login1 = new ArrayList<>();
		login1.add(user.getUserName());
		login1.add(user.getUserPwd());
		
		
		List<User> users = UserDao.findUser(sql, login1);
		
		
		//传递传输到jsp对应的 jstl标签
		if(users.size()==0) {
			request.setAttribute("error", "用户名或密码错误");
			request.getRequestDispatcher("forgound/login.jsp").forward(request, response);
		} else {
			User userSession=users.get(0);
			request.getSession().setAttribute("userSession", userSession);
			request.setAttribute("user", user.getUserName());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

}
