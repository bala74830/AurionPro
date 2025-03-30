<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H1>Welcome Admin</H1><br>
<h3>Add Customer Details </h3><br>
<form action="addNewCustomerServlet" method="post">
User Name : <input type="text" name="username"><br><br>
First Name : <input type="text" name="firstname"><br><br>
Last Name : <input type="text" name="lastname"><br><br>
Email : <input type="text" name="email"><br><br>
Password : <input type="text" name="password"><br><br>
<button type="submit">Submit</button>
<button type="button" onclick="window.location.href='AddNewCustomer.jsp'">Cancel</button>
</form>
</body>
</html>