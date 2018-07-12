package com.food.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.Food;
import com.food.bean.HDFS;
import com.food.service.HDFSService;
import com.food.serviceImpl.HDFSServiceImpl;
import com.food.utils.PageBean;
@WebServlet("/ShowHdfsServlet")
public class ShowHdfsServlet extends HttpServlet {
	private HDFSService hdfsService=new HDFSServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("页面信息");
		/*
		 * 1. 得到pc：如果页面传递使用页面的，否则pc=1
		 */
		int pc = getPc(request);
		System.out.println(pc);
		/*
		 * 2. 得到url：xxx
		 */
		String url = getUrl(request);
		System.out.println(url);
		
		PageBean<HDFS> pb=hdfsService.showAllFile(pc);

		pb.setUrl(url);
		
		System.out.println(pb);
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/forgound/hdfs.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

	/**
	 * 得到pc 当前页码
	 * @param request
	 * @return
	 */
	private int getPc(HttpServletRequest request){
		int pc = 1;
		String param = request.getParameter("pc");
		if(param != null && !param.trim().isEmpty()){
			try {
				pc = Integer.parseInt(param);
			} catch (RuntimeException e) {}
		}
		return pc;
	}
	
	/**
	 * 截取url,页面中的分页导航中需要使用它作为超链接的目标
	 * @param request
	 * @return
	 */
	private String getUrl(HttpServletRequest request){
		String url = request.getRequestURI() + "?" + request.getQueryString();
		/*
		 * 如果url中存在pc参数，截取掉，如果不存在那就不用截取
		 */
		int index = url.lastIndexOf("&pc=");
		if(index != -1) {
			url = url.substring(0, index);
		}
		return url;
	}

}
