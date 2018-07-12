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
 * Servlet implementation class DownloadHDFSServlet
 */
@WebServlet("/DownloadHDFSServlet")
public class DownloadHDFSServlet extends HttpServlet {
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
		String localDst="C:\\Users\\Administrator\\Desktop\\download"; //暂且指定一个本地目录
		boolean res=service.downloadFromHDFS(path, localDst);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		if (res) {
			out.write("<script>alert('下载成功！'); window.location.assign('/Food/ShowHdfsServlet') </script>");
		}else {
			out.write("<script>alert('下载失败！'); window.location.assign('/Food/ShowHdfsServlet') </script>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
