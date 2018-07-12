package com.food.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.User;
import com.food.utils.DefaultServlet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/TestLoginServlet")
public class TestLoginServlet extends DefaultServlet {
	private static final long serialVersionUID = 1L;
	
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("123") && password.equals("123")) {
			User user = new User();
			user.setUserId(1);
			user.setUserName(username);
			user.setUserPwd(password);
			request.getSession().setAttribute("userSession", user);
			return "r:/index.jsp";
		} else {
			request.setAttribute("msg", "用户名或密码错误");
			return "f:/forgound/error.jsp";
		}
	}

}
