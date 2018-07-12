package com.food.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.food.bean.Message;
import com.food.service.MessageService;
import com.food.serviceImpl.MessageServiceImpl;

/**
 * Servlet implementation class UpdateNoticeServlet
 */
@WebServlet("/UpdateNoticeServlet")
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	public UpdateNoticeServlet(){
		super();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//处理响应编码
//		request.setCharacterEncoding("UTF-8");
		
		String title=request.getParameter("title");
			String detail=request.getParameter("noticecontent");
			String id=request.getParameter("mid");			
			MessageService messageService=new MessageServiceImpl(); 
			Message message=new Message();
//			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			message.setTitle(title);
			message.setDetail(detail);
			message.setMid(Integer.parseInt(id));
			boolean flag=messageService.update(message);
			if(flag){
				out.write("<script>alert('修改成功！'); window.location.assign('/Food/ShowAllNoticeSerlet') </script>");
			}else{
				out.write("<script>alert('修改失败！'); window.location.assign('/Food/ShowAllNoticeSerlet') </script>");
			}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//处理响应编码
		MessageService messageService=new MessageServiceImpl(); 
		String mid=request.getParameter("mid");
		Message message =messageService.findByCondition(Integer.parseInt(mid));
		request.setAttribute("mess", message);
		request.getRequestDispatcher("/background/updateNotice.jsp").forward(request,response);
		

	}
}
