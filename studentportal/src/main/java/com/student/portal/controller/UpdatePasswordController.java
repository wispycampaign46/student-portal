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
 * Servlet implementation class UpdatePasswordController
 */
public class UpdatePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePasswordController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pass1, pass2 = null;
		boolean value = false;
		StudentService service = null;

		try {
			pass1 = request.getParameter("password");
			pass2 = request.getParameter("confirmpassword");

			if (!pass1.equals(pass2)) {
				throw new Exception("password not same");
			}

			Student student = (Student) request.getSession().getAttribute("student");

			
			
			student.setPassword(pass1);

			service = new StudentServiceImpl();
			value = service.updatePassword(student);
			if (!value) {
				throw new Exception("Failed to update the password");
			}

		} catch (Exception e) {
			System.err.println("Exception in the controller of updatepassword " + e.getMessage());
		}
		response.getWriter().println(value ? "Updated success" : "failed to yupdate password");
	}

}
