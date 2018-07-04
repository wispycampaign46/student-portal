package com.student.portal.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;

import com.student.portal.dao.StudentDao;
import com.student.portal.daoimpl.StudentDaoImpl;
import com.student.portal.entity.Reciver;
import com.student.portal.entity.Sender;
import com.student.portal.entity.Student;
import com.student.portal.service.MessageingService;
import com.student.portal.service.StudentService;
import com.student.portal.util.Utility;

public class StudentServiceImpl implements StudentService {

	private static Sender sender = new Sender(EMAIL, PASSWORD, SUBJECT, null);

	@Override
	public Student getStudent(int id, String password) {
		Connection connection = null;
		StudentDao dao = null;
		Student student = null;

		try {
			connection = Utility.getConnection();// CONNECTION ESTABLISHING
			dao = new StudentDaoImpl();
			student = dao.selectStudent(connection, id, password);
System.out.println(student+" the value of the studfent that is fetched");
			if (student == null) {
				throw new Exception("No records found");
			}

		} catch (Exception e) {
			System.err.println("Exception in [getStudent] " + e.getMessage());

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

	@Override
	public String forgotPassword(Student student) {
		Connection connection = null;
		StudentDao dao = null;
		String newPassword = null;
		Student existingStudent = null;
		Reciver reciver = null;
		MessageingService messageingService = null;
		String sentMessage = null;
		try {
			connection = Utility.getConnection();
			dao = new StudentDaoImpl();

			existingStudent = dao.selectStudent(connection, student);

			if (existingStudent == null) {
				throw new Exception("No records found");
			}
			newPassword = Utility.generateRandomPassword();
			newPassword = dao.resetPassword(connection, existingStudent.getId(), newPassword);
			if (newPassword == null) {
				throw new Exception("Could not reset the password");
			}

			messageingService = new MessageServiceImpl();
			reciver = new Reciver();
			reciver.setEmailId(existingStudent.getEmail());
			sender.setMessage(MESSAGE + "\n" + "Password : " + newPassword);
			messageingService.setMessageType(new EmailServiceImpl(sender, reciver));
			sentMessage = messageingService.sendMessage();
			if (sentMessage.equals(MessageingService.FAILURE)) {
				throw new Exception(MessageingService.FAILURE);
			}

			connection.commit();
		} catch (Exception e) {
			System.err.println("Exception in [forgotPassword][StudentServiceImpl] " + e.getMessage());

			try {
				connection.rollback();
			} catch (SQLException e1) {

				System.err.println("Exception in [forgotPassword][rollbacking] " + e1.getMessage());

			}

		} finally {
			Utility.closeConnection(connection);
		}
		
		System.out.println(sentMessage);
		return sentMessage;

	}

	@Override
	public boolean updatePassword(Student student) {

		Connection connection = null;
		StudentDao dao = null;
		boolean updatedPassword = false;
		try {
			connection = Utility.getConnection();// CONNECTION ESTABLISHING
			dao = new StudentDaoImpl();

			updatedPassword = dao.updatePassword(connection, student.getId(), student.getPassword());
			if (!updatedPassword) {
				throw new Exception("Failed to update student password");
			}
			connection.commit();

		} catch (Exception e) {
			System.err.println("Exception in [updatePassword] " + e.getMessage());

			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.err.println("Exception in [updatePassword][rollbacking] " + e1.getMessage());
			}
		} finally {
			Utility.closeConnection(connection);
		}

		return updatedPassword;

	}

}
