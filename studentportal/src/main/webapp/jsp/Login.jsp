<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login Portal</title>
</head>
<body>


	<div title="Login Form" align="center">
		<h4>Welcome to Student portal Login</h4>
		<h3>${param.msg}</h3>
		<h3>${id}</h3>
	</div>

	<fieldset>
		<form action="loginController" method="post">
			<table align="center">

				<tr>
					<td>Registeration id</td>
					<td><input type="text" name="userId" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" value="" /></td>
				</tr>

				<tr>
					<td><a href="register">Register</a></td>
					<td><input type="submit" value="Sign in" /></td>
				</tr>

			</table>

		</form>
	</fieldset>

</body>
</html>