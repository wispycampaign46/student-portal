package com.student.portal.listners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class UserLogger
 *
 */
public class UserLogger implements HttpSessionListener {
	static final Logger LOG = Logger.getLogger(UserLogger.class);
	/**
	 * Default constructor.
	 */
	public UserLogger() {
		BasicConfigurator.configure();
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		LOG.info(se.getSession().getId() + " " + "created session");
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		LOG.info(se.getSession().getId() + " " + "removed session");
	}

}
