package com.student.portal.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.student.portal.dao.StudentDao;
import com.student.portal.entity.Student;
import com.student.portal.util.Utility;

public class StudentDaoImpl implements StudentDao {

	@Override
	public int insertStudent(Student student, Connection connection) {
		PreparedStatement preparedStatement = null;
		int generatedId = 0;
		ResultSet iDGenerator = null;

		try {
			preparedStatement = connection.prepareStatement(INSERT_STUDENT, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, student.getName());

			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setString(3, student.getMobile());
			preparedStatement.setString(4, student.getPassword());

			preparedStatement.executeUpdate();
			iDGenerator = preparedStatement.getGeneratedKeys();
			if (iDGenerator.next()) {

				generatedId = iDGenerator.getInt(1);

			}

		} catch (Exception e) {
			System.err.println("Exception in [daoimpl] " + e.getMessage());

		} finally {
			Utility.closeResources(preparedStatement, iDGenerator);

		}

		return generatedId;
	}

	@Override
	public Student selectStudent(Connection connection, int userId, String password) {
		PreparedStatement preparedStatement = null;

		ResultSet returnStudent = null;
		Student student = null;
		try {
			preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, password);

			returnStudent = preparedStatement.executeQuery();
			if (returnStudent.next()) {
				student = new Student();
				student.setEmail(returnStudent.getString("email"));
				student.setMobile(returnStudent.getString("mobile"));
				student.setId(returnStudent.getInt("id"));
				student.setName(returnStudent.getString("name"));
				student.setPassword(returnStudent.getString("password"));
			}

			// System.out.println(student);

		} catch (Exception e) {
			System.err.println("Exception in [daoimpl] " + e.getMessage());
		} finally {
			Utility.closeResources(preparedStatement, returnStudent);
		}
		return student;
	}

	@Override
	public Student selectStudent(Connection connection, Student studentValue) {

		PreparedStatement preparedStatement = null;
		Student student = null;
		ResultSet returnStudent = null;
		try {
			preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID_ONLY);
			preparedStatement.setInt(1, studentValue.getId());

			returnStudent = preparedStatement.executeQuery();
			if (!returnStudent.next()) {

				throw new Exception("No records found..");
			}
			student = new Student();
			student.setId(returnStudent.getInt("id"));
			student.setName(returnStudent.getString("name"));
			student.setMobile(returnStudent.getString("mobile"));
			student.setEmail(returnStudent.getString("email"));
			student.setPassword(returnStudent.getString("password"));

		} catch (Exception e) {
			System.err.println("Exception in [daoimpl] " + e.getMessage());
		} finally {
			Utility.closeResources(preparedStatement, returnStudent);

		}

		return student;
	}

	@Override
	public String resetPassword(Connection connection, int userName, String userpassword) {
		PreparedStatement preparedStatement = null;
		String password = null;
		ResultSet iDGenerator = null;

		try {
			preparedStatement = connection.prepareStatement(UPDATE_STUDENT_PASSWORD);
			preparedStatement.setString(1, userpassword);
			preparedStatement.setInt(2, userName);

			if (preparedStatement.executeUpdate() < 1) {
				throw new Exception("failed to reset the password");

			}

			password = userpassword;

		} catch (Exception e) {
			System.err.println("Exception in [daoimpl] " + e.getMessage());

		} finally {
			Utility.closeResources(preparedStatement, iDGenerator);

		}

		return password;
	}

	@Override
	public boolean updatePassword(Connection connection, int id, String newpassword) {
		boolean isUpdated = false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			preparedStatement = connection.prepareStatement(UPDATE_STUDENT_PASSWORD);


			preparedStatement.setString(1, newpassword);
			preparedStatement.setInt(2, id);
			System.out.println(preparedStatement.executeUpdate() + " the number of rows updated here ");
			if (preparedStatement.executeUpdate() < 1) {
				throw new Exception("Failed to update the student password");
			}
			isUpdated = true;

		} catch (Exception e) {
			System.err.println("Exception in [studentdaoimpl][updatePassword] " + e.getMessage()); // TODO: handle
																									// exception

			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.err.println("Exception in [studentdaoimpl][updatePassword]  ROLLBACKING" + e.getMessage()); // TODO:
																													// handle
																													// exception

			}

		}

		finally {
			Utility.closeResources(preparedStatement, resultSet);
			System.out.println("The value to be returned is " + isUpdated);
		}
		return isUpdated;

	}

}
