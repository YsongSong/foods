package com.food.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.Message;
import com.food.service.MessageService;
import com.food.serviceImpl.MessageServiceImpl;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");//处理响应编码
		MessageService messageService=new MessageServiceImpl(); 
		String title=request.getParameter("noticetitle");
		String detail=request.getParameter("noticecontent");
		PrintWriter out=response.getWriter();
		Message message = new Message();
		message.setTitle(title);
		message.setDetail(detail);
		boolean flag=messageService.insert(message);
		if(flag) {
			out.write("<script>alert('插入成功！'); window.location.assign('/Food/ShowAllNoticeSerlet') </script>");
		}else{
			out.write("<script>alert('插入失败！'); window.location.assign('/Food/ShowAllNoticeSerlet') </script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");//处理响应编码
		doGet(request, response);
	}

}
