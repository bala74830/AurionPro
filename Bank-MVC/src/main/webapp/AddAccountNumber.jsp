<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Add Bank Account</title>
</head>
<body>
	<h1>Generate Account Number</h1>
	<form action="generateRandomServlet" method="post">
		<label for="customerId">Enter Customer ID:</label> <input type="text"
			name="customerId"  placeholder="Enter customer ID"
			required>
		<button type="submit">Search for Customer Details</button>
	</form>
</body>
</html>