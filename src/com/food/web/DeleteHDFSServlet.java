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

/**
 * Servlet implementation class DeleteHDFSServlet
 */
@WebServlet("/DeleteHDFSServlet")
public class DeleteHDFSServlet extends HttpServlet {
	private HDFSService service=new HDFSServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		boolean res=service.deleteFile(path, hid);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		if (res) {
			out.write("<script>alert('删除成功！'); window.location.assign('/Food/ShowHdfsServlet') </script>");
		}else {
			out.write("<script>alert('删除失败！'); window.location.assign('/Food/ShowHdfsServlet') </script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
