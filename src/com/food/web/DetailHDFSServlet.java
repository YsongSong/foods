package com.food.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.HDFS;
import com.food.service.HDFSService;
import com.food.serviceImpl.HDFSServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javafx.animation.ScaleTransition;

@WebServlet("/DetailHDFSServlet")
public class DetailHDFSServlet extends HttpServlet {
	private HDFSService service=new HDFSServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----DetailHDFSServlet");
		String hidStr=request.getParameter("hid");
		int hid=0;
		String path="";
		HDFS hdfs=null;
		if(hidStr.length()>0&&hidStr!=null){
			hid=Integer.parseInt(hidStr);
			hdfs=service.findHDFSById(hid);
		}
		if (hdfs!=null) {
			String t=hdfs.getFilepath();
			path=t.substring(26, t.length());
		}
		String res=service.detailFile(path);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		if (res!=null) {
//			out.write("<script>alert('"+res+"'); window.location.assign('/Food/ShowHdfsServlet') </script>");
			request.setAttribute("res", res);
			request.getRequestDispatcher("forgound/hdfsDetail.jsp").forward(request, response);
		}else {
			out.write("<script>alert('查看失败！'); window.location.assign('/Food/ShowHdfsServlet') </script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
