<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reset Password</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/ResetPasswordController" method="POST">
		<table>
			<tr>
				<td>Enter your registeration id</td>
				<td><input type="text" name="regId" /></td>

			</tr>
			<tr>
				<td>Security Question when you you registered</td>
				<td><select name="secQ">
						<option>Which is your first school ?</option>
						<option>Which is your native place ?</option>
						<option>What is your first pets name ?</option>
						<option>Which is your first car ?</option>
						<option>Which is your fav place ?</option>
						<option>Where were your born ?</option>
						<option>Which year did you graduate ?</option>
						<option>Which is your fav color ?</option>
						<option>When did you buy a car ?</option>
						<option>What is your nick name ?</option>
						<option>Which is your fav car ?</option>

				</select></td>
			</tr>
			<tr>

				<td>Answer</td>
				<td><input type="text" name="secAns"></td>
			</tr>

			<tr>

				<td></td>
				<td><input type="submit" value="Reset password"></td>
			</tr>


		</table>
	</form>





</body>
</html>