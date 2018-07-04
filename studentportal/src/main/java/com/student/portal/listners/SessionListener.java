package com.student.portal.listners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionListener {

	public SessionListener() {


	}

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("HttpSession is created here");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("HttpSession is destroyed here");

	}

}
