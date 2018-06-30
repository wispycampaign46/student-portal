package com.student.portal.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;

import com.student.portal.dao.StudentDao;
import com.student.portal.daoimpl.StudentDaoImpl;
import com.student.portal.entity.Student;
import com.student.portal.service.StudentService;
import com.student.portal.util.Utility;

public class StudentServiceImpl implements StudentService {

	@Override
	public Student getStudent(int id, String password) {
		Connection connection = null;
		StudentDao dao = null;
		Student student = null;

		try {
			connection = Utility.getConnection();// CONNECTION ESTABLISHING
			dao = new StudentDaoImpl();
			student = dao.selectStudent(connection, id, password);
			if (student == null) {
				throw new Exception("No records found");
			}
			connection.commit();
		} catch (Exception e) {
			System.err.println("Exception in [getStudent] " + e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.err.println("Exception in [getStudent][rollbacking] " + e1.getMessage());
			}
		} finally {
			Utility.closeConnection(connection);
		}
		return student;
	}

	@Override
	public int registerStudent(Student student) {
		Connection connection = null;
		StudentDao dao = null;
		int uniqueId = 0;
		try {
			connection = Utility.getConnection();// CONNECTION ESTABLISHING
			dao = new StudentDaoImpl();

			uniqueId = dao.insertStudent(student, connection);
			if (uniqueId < 0) {
				throw new Exception("Failed to register student");
			}
			connection.commit();

		} catch (Exception e) {
			System.err.println("Exception in [registerStudent] " + e.getMessage());
			uniqueId = 0;
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.err.println("Exception in [getStudent][rollbacking] " + e1.getMessage());
			}
		} finally {
			Utility.closeConnection(connection);
		}

		return uniqueId;
	}

}
