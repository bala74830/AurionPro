<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Register</title>
</head>
<body>
<form action="customerServlet" method="post">
<% String username = (String)session.getAttribute("username"); 
 String password = (String)session.getAttribute("password"); %>
Username: <input type="text" value=<%= username%>><br><br>
Password: <input type="text" value=<%= password%>><br><br>
FirstName: <input type="text" name="firstname"><br><br>
LastName: <input type="text" name="lastname"><br><br>
Email: <input type="text" name="email"><br><br>
<button name="submitbtn">Submit</button>
</form>
</body>
</html>