<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registeration Page</title>

</head>

<body>
	<h1 align="center">Student Registeration Form</h1>
			<h3>${param.msg}</h3>
	<form action="RegisterationContorller" method="POST">

		<table align="center">
			<tr>

				<td>Student Name</td>
				<td><input type="text" name="name" value="${requestScope.name}"></td>
			</tr>


			<tr>

				<td>Student mobile number</td>
				<td><input type="text" name="mobile" value="${requestScope.mobile}"></td>
			</tr>
			<tr>

				<td>Student email id</td>
				<td><input type="text" name="email" value="${requestScope.email}"></td>
			</tr>


			<tr>

				<td>Student password</td>
				<td><input type="password" name="singlePassword" value=""></td>
			</tr>
			<tr>
				<td>Student password re-enter</td>
				<td><input type="password" name="doublePassword"></td>
			</tr>


			<tr>
				<td><a href="login">Login</a></td>
				<td><input type="submit" value="Register"></td>
			</tr>



		</table>


	</form>





</body>
</html>