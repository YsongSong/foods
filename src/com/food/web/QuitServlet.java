package com.food.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.utils.DefaultServlet;

/**
 * Servlet implementation class QuitServlet
 */
@WebServlet("/QuitServlet")
public class QuitServlet extends DefaultServlet {
	private static final long serialVersionUID = 1L;
       
	public String quit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		return "r:/index.jsp";
	}

}
