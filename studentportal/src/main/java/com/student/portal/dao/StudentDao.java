package com.student.portal.dao;

import java.sql.Connection;

import com.student.portal.entity.Student;

public interface StudentDao {
	String INSERT_STUDENT = "insert into student(name,email,mobile,password) values(?,?,?,?)";
	String SELECT_STUDENT_BY_ID = "select * from student where id=? and password=?";
	String SELECT_STUDENT_BY_ID_ONLY = "select * from student where id=?";
	String UPDATE_STUDENT_PASSWORD = "update student set password=? where id=?";

	int insertStudent(Student student, Connection connection);

	Student selectStudent(Connection connection, int userName, String password);

	Student selectStudent(Connection connection, Student student);

	String resetPassword(Connection connection, int userName,String userpassword);

	boolean updatePassword(Connection connection, int id, String newpassword);

}
