package com.student.portal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.portal.entity.Student;
import com.student.portal.service.StudentService;
import com.student.portal.serviceimpl.StudentServiceImpl;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		throw new IOException("GET Method is not allowed");	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = null;
		int userId = 0;
		RequestDispatcher rd = null;
		StudentService service = null;
		Student student = null;
		try {
			try {
				userId = Integer.parseInt(request.getParameter("userId"));
			} catch (Exception e) {
				throw new Exception("Empty fields found ...");
			}
			password = request.getParameter("password");
			if (userId <= 0 || password == null) {
				throw new Exception("Empty fields found ...");
			}
			System.out.println("The hit values are "+userId+"   "+password);
			
			
			
			service = new StudentServiceImpl();
			student = service.getStudent(userId, password);
			if (student == null) {
				throw new Exception("No student records found please register");
			}

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}

		request.setAttribute("student", student);
		rd = request.getRequestDispatcher("PostLoginController");
		rd.forward(request, response);

	
	}

}
