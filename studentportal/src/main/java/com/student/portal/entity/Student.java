package com.student.portal.entity;

import java.io.Serializable;

public class Student implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String email;
	private String mobile;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student() {
	}// DEFAULT CONSTRUCTOR

	public Student(String name, String email, String mobile, String password, int id) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.id = id;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", password="
				+ password + "]";
	}

}
