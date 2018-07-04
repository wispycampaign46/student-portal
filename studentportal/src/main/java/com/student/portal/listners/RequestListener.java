package com.student.portal.listners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
public class RequestListener implements ServletRequestListener {

	private int totalRequestToServer=0;

    public RequestListener() {}

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	
      System.out.println("Request is going to die");
    }

	
    public void requestInitialized(ServletRequestEvent sre)  { 

    System.out.println("Request is created now req no "+ ++totalRequestToServer);
    }
}
