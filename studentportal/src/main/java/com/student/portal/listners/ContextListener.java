package com.student.portal.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class COntextListener
 *
 */
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
      System.out.println("Context closing application stops");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	  try {
    			 sce.getServletContext().getClassLoader().loadClass("com.student.portal.util.Utility");
    	        } catch (ClassNotFoundException e) {
    			System.out.println("Could not find the class ");
    				e.printStackTrace();
    			}
    }
	
}
