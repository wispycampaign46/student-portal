<%@page import="com.student.portal.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Details</title>

</head>
<body>
	<h2>Welcome</h2>

	<h3>${sessionScope.student}</h3>
	<h4>Update password</h4>

	<form action="UpdatePasswordController" method="post">
		Password<input type="password" name="password" /><br /> Confirm
		Password<input type="password" name="confirmpassword" /><br /> <input
			type="submit" value="update" />
	</form>


</body>
</html>