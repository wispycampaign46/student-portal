package com.student.portal.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class LoggingFilter
 */
public class LoggingFilter implements Filter {
	Logger LOG = null;

	/**
	 * Default constructor.
	 */
	public LoggingFilter() {
		LOG = Logger.getLogger("Name");
		BasicConfigurator.configure();
		LOG.info("created LoggingFilter");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		LOG.info("destroy LoggingFilter");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		LOG.info("doFilter LoggingFilter started");

		chain.doFilter(request, response);
		LOG.info("doFilter LoggingFilter ended");

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		LOG.info("init LoggingFilter");
	}

}
