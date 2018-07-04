package com.student.portal.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.portal.entity.Student;

public class ValidationFilter extends Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hres = (HttpServletResponse) response;

		String name = hreq.getParameter("name");
		String mobile = hreq.getParameter("mobile");
		String email = hreq.getParameter("email");
		String psw1 = hreq.getParameter("singlePassword");
		String psw2 = hreq.getParameter("doublePassword");
		Student student = new Student(name, email, mobile, psw1, 0);
		// CHECK FOR VALID NAME
		Map<String, String> value = null;
		hres.setStatus(200);
		StringBuffer errorMessage = new StringBuffer();
		if (psw2.equals(psw1)) {

			value = validateFields(student);

			if (value.keySet().size() == 0) {
				chain.doFilter(request, response);
				return;
			}

			Iterator<String> it = value.keySet().iterator();

			while (it.hasNext()) {
				errorMessage.append(value.get(it.next())).append("\n");
			}
			hres.getWriter().print(errorMessage + "\n");
			hreq.setAttribute("name", student.getName());
			hreq.setAttribute("mobile", student.getMobile());
			hreq.setAttribute("email", student.getEmail());
		} else {
			hres.getWriter().print("Different passwords entered" + "\n");
		}
		hres.setContentType("text/html");
		hreq.getRequestDispatcher("register").include(hreq, hres);
		return;
	}

	private Map<String, String> validateFields(Student student) {
		String name = student.getName();
		Map<String, String> errors = new HashMap<String, String>();
		Pattern pattern = Pattern.compile("[a-zA-Z]{3,}");
		Matcher m = pattern.matcher(name.trim());
		if (!m.find()) {

			errors.put("name", "Mimimum 3 characters in name");
		}
		String mobile = student.getMobile();
		m = Pattern.compile("[0-9]{10}").matcher(mobile.trim());
		if (!m.find()) {
			errors.put("mobile", "Invalid mobile format");
		}
		String password = student.getPassword();
		String PASSREG = "^[A-Z][a-z]*([0-9][a-z]*[#$@]|[#$@][a-z]*[0-9])[a-z]*$";
		if (!Pattern.compile(PASSREG).matcher(password.trim()).find()) {
			errors.put("password",
					"Password must contain Starting cap exact one special char [@,#,$] and  1 number ,lower cases and total leng >7");
		}

		return errors;
	}

}
