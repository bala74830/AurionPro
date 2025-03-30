<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
</head>
<body>
<h1>Edit Profile</h1>
<form action="editProfileServlet" method="post">
FirstName: <input type="text" name="firstname" required="required"><br><br>
LastName: <input type="text" name="lastname" required="required"><br><br>
Email: <input type="text" name="email" required="required"><br><br>
Password: <input type="text" name="password" required="required"><br><br>
<button name="updatebtn">Submit</button>
<button type="button" onclick="window.location.href='<%= request.getContextPath() %>/EditProfile.jsp'">Cancel</button>
</form>
</body>
</html>