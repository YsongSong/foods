package com.food.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.bean.Dish;
import com.food.service.MapService;
import com.food.serviceImpl.MapServiceImpl;

@WebServlet("/ShowMap")
public class ShowMap extends HttpServlet {
	private MapService mapService=new MapServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dish> list=mapService.getMapData();
		request.setAttribute("map", list);
		request.getRequestDispatcher("/forgound/map.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
