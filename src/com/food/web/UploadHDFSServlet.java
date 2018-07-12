package com.food.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.food.bean.HDFS;
import com.food.service.HDFSService;
import com.food.serviceImpl.HDFSServiceImpl;

/**
 * Servlet implementation class UploadHDFSServlet
 */
@MultipartConfig
@WebServlet("/UploadHDFSServlet")
public class UploadHDFSServlet extends HttpServlet {
	private HDFSService service=new HDFSServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/forgound/fileupload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base=request.getServletContext().getRealPath("upload");
		File file=new File(base);
		if (!file.exists()) {
			file.mkdir();
		}
		Part part=request.getPart("filename");
		String filePath=base+"\\"+part.getSubmittedFileName();
		part.write(filePath);
		HDFS hdfs=new HDFS();
		String name=part.getSubmittedFileName();
		hdfs.setFileName(name);
		hdfs.setFilepath(filePath);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		if (service.findHDFS(hdfs).size()==0) {
			boolean flag=service.uploadToHDFS(hdfs,"/user/hadoop/input/");
			if(flag){
				out.write("<script>alert('上传成功！'); window.location.assign('/Food/UploadHDFSServlet') </script>");
			}
			else {
				out.write("<script>alert('上传失败！'); window.location.assign('/Food/UploadHDFSServlet') </script>");
			}
		}else {
			out.write("<script>alert('文件已存在！'); window.location.assign('/Food/UploadHDFSServlet') </script>");
		}
	
	}

}
