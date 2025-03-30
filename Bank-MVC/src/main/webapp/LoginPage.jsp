<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1>Welcome to Bank</h1>
<h2>Login Page</h2>
<form action="loginServlet" method="post">
Username: <input type="text" name="username" required="required"><br><br>
Password: <input type="text" name="password" required="required"><br><br>
<select name="role">
<option value="admin">Admin</option>
<option value="customer">Customer</option>
</select><br><br>
<button name="loginbtn">Login</button>
</form>
</body>
</html>