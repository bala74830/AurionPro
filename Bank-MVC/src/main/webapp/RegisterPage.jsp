<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<h1>Welcome to the Bank</h1>
<h2>Register Page</h2>
<form action="registerServlet" method="post" >
Username: <input type="text" name="username" required="required"><br><br>
Password: <input type="text" name="password" required="required"><br><br>
<select name="role" required="required">
<option value="admin">Admin</option>
<option value="customer">Customer</option>
</select><br><br>
<button name="submitbtn">Submit</button>
<button type="button" onclick="window.location.href='<%= request.getContextPath() %>/RegisterPage.jsp'">Cancel</button>
</form>
</body>
</html>