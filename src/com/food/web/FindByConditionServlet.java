package com.food.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.Message;
import com.food.service.MessageService;
import com.food.serviceImpl.MessageServiceImpl;

/**
 * Servlet implementation class FindByConditionServlet
 */
@WebServlet("/FindByConditionServlet")
public class FindByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see 构造方法
     */
    public FindByConditionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see 处理GET请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 调用业务层
		MessageService messageService=new MessageServiceImpl();
		String mid=request.getParameter("mid");
		Message message=messageService.findByCondition(Integer.parseInt(mid));
		request.setAttribute("mess", message);
		request.getRequestDispatcher("forgound/message.jsp").forward(request, response);
	}

	/**
	 * 处理post请求
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}