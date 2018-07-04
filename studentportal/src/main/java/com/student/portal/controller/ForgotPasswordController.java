package com.student.portal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.portal.entity.Student;
import com.student.portal.service.StudentService;
import com.student.portal.serviceimpl.StudentServiceImpl;

/**
 * Servlet implementation class ForgotPasswordController
 */
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentService service = new StudentServiceImpl();
		Student student = new Student();

		int id = Integer.parseInt(request.getParameter("id"));
		student.setId(id);

		String responseData=service.forgotPassword(student);

		response.getWriter().println(responseData);
		
		
		
	}

}
