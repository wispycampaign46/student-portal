package com.student.portal.service;

import com.student.portal.entity.Student;

public interface StudentService {
	 static final String PASSWORD = "ABC12345six";
	 static final String EMAIL = "studentportal.manager@gmail.com";
	 static final String SUBJECT = "Reset Password";
	 String MESSAGE="Password has been resetted use the below password to login next time";
	public Student getStudent(int id, String password);

	int registerStudent(Student student);

	String forgotPassword(Student student);
	
	boolean updatePassword(Student student);
	
	
}
