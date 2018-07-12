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
import com.food.utils.StringUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");;
		//调用业务层
		UserDao UserDao=new UserDaoImpl();
	
		String userName=request.getParameter("userName");
		String userPwd=request.getParameter("userPwd");
		String userPwd2 = request.getParameter("userPwd2");
		String userSex=request.getParameter("userSex");
		String userAge=request.getParameter("userAge");
		String userNum=request.getParameter("userNum");
		String userAddress=request.getParameter("userAddress");
		String userPhone=request.getParameter("userPhone");
		String userEmail=request.getParameter("userEmail");
		String userPostNum=request.getParameter("userPostNum");
		
		if(StringUtil.isEmpty(userName)) {
			request.setAttribute("error", "用户名不能为空");
			request.getRequestDispatcher("forgound/regist.jsp").forward(request, response);
			return;
		}
		if(StringUtil.isEmpty(userPwd)) {
			request.setAttribute("error", "密码不能为空");
			request.getRequestDispatcher("forgound/regist.jsp").forward(request, response);
			return;
		}
		if(StringUtil.isEmpty(userPwd2)) {
			request.setAttribute("error", "确认密码不能为空");
			request.getRequestDispatcher("forgound/regist.jsp").forward(request, response);
			return;
		}
		if(StringUtil.isEmpty(userAge)) {
			request.setAttribute("error", "年龄不能为空");
			request.getRequestDispatcher("forgound/regist.jsp").forward(request, response);
		}
		if(StringUtil.isEmpty(userNum)) {
			request.setAttribute("error", "身份证号不能为空");
			request.getRequestDispatcher("forgound/regist.jsp").forward(request, response);
			return;
		}
		if(StringUtil.isEmpty(userAddress)) {
			request.setAttribute("error", "地址不能为空");
			request.getRequestDispatcher("forgound/regist.jsp").forward(request, response);
			return;
		}
		if(StringUtil.isEmpty(userPhone)) {
			request.setAttribute("error", "电话号码不能为空");
			request.getRequestDispatcher("forgound/regist.jsp").forward(request, response);
			return;
		}
		if(StringUtil.isEmpty(userEmail)) {
			request.setAttribute("error", "邮箱不能为空");
			request.getRequestDispatcher("forgound/regist.jsp").forward(request, response);
			return;
		}
		if(StringUtil.isEmpty(userPostNum)) {
			request.setAttribute("error", "邮编不能为空");
			request.getRequestDispatcher("forgound/regist.jsp").forward(request, response);
			return;
		}
		
		
		
		
		User user=new User(userName,userPwd,userSex,Integer.parseInt(userAge),userNum,userAddress,userPhone,userEmail,userPostNum);
		String sql="insert into  user(userName,userPwd,userSex,userAge,userNum,userAddress,userPhone,userEmail,userPostNum )"
				+ "values(?,?,?,?,?,?,?,?,?)";
		ArrayList<Object>register1 = new ArrayList<>();
		register1.add(user.getUserName());
		register1.add(user.getUserPwd()); 
		register1.add(user.getUserSex());
		register1.add(user.getUserAge());
		register1.add(user.getUserNum());
		register1.add(user.getUserAddress());
		register1.add(user.getUserPhone());
		register1.add(user.getUserEmail());
		register1.add(user.getUserPostNum());
		
		String sql2 = "select * from user where userName=?";
		ArrayList<Object> register2 = new ArrayList<>();
		register2.add(user.getUserName());
		List<User> registerUserName = UserDao.findUser(sql2, register2);

		String sql3 = "select * from user where userNum=?";
		ArrayList<Object>  register3 = new ArrayList<>();
		register3.add(user.getUserNum());
		List<User> registerUserNum = UserDao.findUser(sql3, register3);
		System.out.println(userPostNum.length());
		
		if (userPwd2.equals(userPwd)) {
			
			if (registerUserName.size() != 0) {
				request.setAttribute("error", "用户名已存在");
				request.getRequestDispatcher("forgound/regist.jsp").forward(request,
						response);
				return;
			} else if (registerUserNum.size() != 0) {
				request.setAttribute("error", "身份证已存在");
				request.getRequestDispatcher("forgound/regist.jsp").forward(request,
						response);
				return;
			} else{
				boolean registerResult = UserDao.register(sql, register1);
				if (registerResult) {
					request.getRequestDispatcher("forgound/login.jsp").forward(
							request, response);
					return;
				}
			}

		} else {
			request.setAttribute("error", "两次密码不相同");
			request.getRequestDispatcher("forgound/regist.jsp").forward(request,
					response);
			return;
		}

//		if (userPostNum.length() == 7) {
//			System.out.println(userPostNum.length());
//		} else {
//			request.setAttribute("msg", "邮箱格式不对不相同");
//			request.getRequestDispatcher("forgound/error.jsp").forward(request,
//					response);
//		}
       }
	}
