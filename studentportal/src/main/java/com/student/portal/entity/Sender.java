package com.student.portal.entity;

import java.io.Serializable;

public class Sender implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Sender() {
	}

	private String emailId;
	private String password;
	private String subject;
	private String message;

	public Sender(String emailId, String password, String subject, String message) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.subject = subject;
		this.message = message;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
