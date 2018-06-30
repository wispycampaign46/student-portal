package com.student.portal.service;

import com.student.portal.entity.Student;

public interface StudentService {

	public Student getStudent(int id, String password);

	int registerStudent(Student student);

}
