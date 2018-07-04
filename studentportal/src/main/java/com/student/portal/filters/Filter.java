package com.student.portal.filters;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

public abstract class Filter implements javax.servlet.Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter is being initalizing ");
		
	}



	@Override
	public void destroy() {

		System.out.println("Filter is being destroyed");
	
	}

}
