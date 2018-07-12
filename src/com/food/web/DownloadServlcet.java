package com.food.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.HDFS;
import com.food.service.HDFSService;
import com.food.serviceImpl.HDFSServiceImpl;
import com.food.utils.HDFSUtils;

/**
 * Servlet implementation class DownloadServlcet
 */
@WebServlet("/DownloadServlcet")
public class DownloadServlcet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HDFSService service=new HDFSServiceImpl();
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hidStr=request.getParameter("hid");
		int hid=0;
		String path="";
		String fileName = null;
		HDFS hdfs=null;
		if(hidStr.length()>0&&hidStr!=null){
			hid=Integer.parseInt(hidStr);
			hdfs=service.findHDFSById(hid);
		}
		if (hdfs!=null) {
			String t=hdfs.getFilepath();
			path=t.substring(t.indexOf("user")-1, t.length());
			fileName = t.substring(t.indexOf("input/") + 6, t.length());
		}
		
		response.setContentType("text/plain;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		ServletOutputStream out = response.getOutputStream();
		String file = HDFSUtils.readHDFS(path);
		out.write(file.getBytes());
		out.flush();
		out.close();
	}

}
