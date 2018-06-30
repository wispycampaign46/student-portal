package com.student.portal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.portal.entity.Student;

/**
 * Servlet implementation class PostLoginController
 */
public class PostLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostLoginController() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student student = null;
		try {
			student = (Student) request.getAttribute("student");

			if (student == null) {
				throw new Exception("invalid userid or password");
			} else {
				// CREATE SESSION OBJECT FOR THE USAGE IN THE APPLICATION
		
				HttpSession x = request.getSession(true);

				
				x.setAttribute("student", student);
				response.sendRedirect("welcome");
			}
		} catch (Exception e) {
			response.sendRedirect("login?msg=" + e.getMessage());
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
