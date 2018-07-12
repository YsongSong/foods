package com.food.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.Message;
import com.food.service.MessageService;
import com.food.serviceImpl.MessageServiceImpl;

/**
 * Servlet implementation class ShowAllNoticeSerlet
 */
@WebServlet("/ShowAllNoticeSerlet")
public class ShowAllNoticeSerlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MessageService messageService=new MessageServiceImpl();
		List<Message> list = messageService.showAllNotice();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/background/showNotice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
