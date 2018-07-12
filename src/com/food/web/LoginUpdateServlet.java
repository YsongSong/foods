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

/**
 * Servlet implementation class LoginUpdateServlet
 */
@WebServlet("/LoginUpdateServlet")
public class LoginUpdateServlet extends HttpServlet {
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
		String userNum=request.getParameter("userNum");
		String userPwd1=request.getParameter("userPwd1");
		
//		User user=new User(userName,userNum,userPwd1);
		
		String sql="select * from user where userName=? and userNum=?";
		ArrayList<Object>login1 = new ArrayList<>();
		login1.add(userName);
		login1.add(userNum);
		
		List<User> users = UserDao.findUser(sql, login1);
		
		
		//传递传输到jsp对应的 jstl标签
		if(users.size()==0) {
			request.setAttribute("error", "用户名或身份证错误");
			request.getRequestDispatcher("forgound/LoginUpdate.jsp").forward(request, response);
		} else
			{
			String sql1="update user set  userPwd=? where userName=?";
			ArrayList<Object>login2 = new ArrayList<>();
			login2.add(userPwd1);
			login2.add(userName);
			boolean result=UserDao.update(sql1, login2);
			if (result) {
				request.getRequestDispatcher("/forgound/login.jsp").forward(request, response);
				request.setAttribute("error", "修改成功！");
			}else {
				request.setAttribute("error", "修改失败！");
			}
		}
		
	}

}
