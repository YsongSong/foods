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
 *
 */
@WebServlet("/DeleteNoticeServlet")
public class DeleteNoticeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MessageService messageService=new MessageServiceImpl();
		response.setCharacterEncoding("gb2312");
		PrintWriter out=response.getWriter();
		String mid=request.getParameter("mid");
		boolean flag=messageService.delete(Integer.parseInt(mid));
		if(flag){
			out.write("<script>alert('删除成功！'); window.location.assign('/Food/ShowAllNoticeSerlet') </script>");
		}else{
			out.write("<script>alert('删除失败！'); window.location.assign('/Food/ShowAllNoticeSerlet') </script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
