package com.food.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.bean.Type;
import com.food.service.AdminService;
import com.food.serviceImpl.AdminServiceImpl;
import com.food.utils.TypeConvert;

/**
 * Servlet implementation class AddFoodType
 */
@WebServlet("/AddFoodType")
public class AddFoodType extends HttpServlet {
	private AdminService adminService=new AdminServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		TypeConvert convertType=(TypeConvert) session.getAttribute("convertType");
		Map<Integer, String> map=convertType.getMap();
		String index=request.getParameter("index");
		String cid=request.getParameter("cid");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		int id = 0;
		if(cid!=null){
			id=Integer.parseInt(cid);
		}
		String target="";
		switch (index) {
		case "add":
			target="/background/addType.jsp";
			request.getRequestDispatcher(target).forward(request, response);
			break;
		case "list":
			target="/background/typeList.jsp";
			List<Type> types=adminService.getTypes(null);
			request.setAttribute("types", types);
			request.getRequestDispatcher(target).forward(request, response);
			break;
		case "update":
			target="/background/updateType.jsp";
			Type type=adminService.getTypes(new Type(id,"")).get(0);
			request.setAttribute("type", type);
			request.getRequestDispatcher(target).forward(request, response);
			break;
		case "delete":
			target="/background/typeList.jsp";
			Type temp=new Type(id,"");
			boolean t=adminService.deleteType(temp);
			if (t) {
				System.out.println("id-----"+temp.getCid()+"---"+map.remove(temp.getCid()));
				
				System.out.println("删除----"+map);
				session.removeAttribute("convertType");
				convertType.setMap(map);
				session.setAttribute("convertType", convertType);
				out.write("<script>alert('删除成功！'); window.location.assign('/Food/AddFoodType?index=list') </script>");
			}else {
				out.write("<script>alert('删除失败！'); window.location.assign('/Food/AddFoodType?index=list') </script>");
			}
			break;
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		TypeConvert convertType=(TypeConvert) session.getAttribute("convertType");
		Map<Integer, String> map=convertType.getMap();
		String cid=request.getParameter("cid");
		int id=0;
		if (cid!=null&&cid.length()>0) {
			id=Integer.parseInt(cid);
		}
		String cidName=request.getParameter("cidName");
		String index=request.getParameter("index");
		Type type=new Type(id, cidName);
		switch (index) {
		case "add":
			boolean flag=adminService.addType(type);
			if (flag) {
				Type temp=adminService.getTypes(new Type(0,type.getCidName())).get(0);
				map.put(temp.getCid(), type.getCidName());
				session.removeAttribute("convertType");
				convertType.setMap(map);
				session.setAttribute("convertType", convertType);
				out.write("<script>alert('添加成功！'); window.location.assign('/Food/AddFoodType?index=list') </script>");
			}else {
				out.write("<script>alert('添加失败！'); window.location.assign('/Food/AddFoodType?index=add') </script>");
			}
			break;
		case "update":
			boolean t=adminService.updateType(type);
			if (t) {
				map.remove(type.getCid());
				map.put(type.getCid(), type.getCidName());
				session.removeAttribute("convertType");
				convertType.setMap(map);
				session.setAttribute("convertType", convertType);
				out.write("<script>alert('修改成功！'); window.location.assign('/Food/AddFoodType?index=list') </script>");
			}else {
				out.write("<script>alert('修改失败！'); window.location.assign('/Food/AddFoodType?index=update') </script>");
			}

			break;


		}
	}
}

