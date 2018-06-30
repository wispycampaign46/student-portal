package com.student.portal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostRegisterationContorller
 */
public class PostRegisterationContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostRegisterationContorller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = (Integer) request.getAttribute("generatedId");
		if (id > 0) {
			// success in registeration send it to login page
			if(request.getSession()==null) {
				request.getSession(true);
			}
			request.getSession().setAttribute("id", "Generated id is "+id);
			response.sendRedirect("login");
		}
		else {
			// send him to registeration page
			response.sendRedirect("register?msg=" + "failed to register");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
