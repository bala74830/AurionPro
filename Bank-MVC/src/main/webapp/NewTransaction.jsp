<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="transactionServlet" method="post">
Type of Transaction: <select name="type">
<option >Type</option>
<option value="credit">Deposit</option>
<option value="debit">Withdraw</option>
<option value="transfer">Transfer</option>
</select><br><br>
Account number:(Use only to Transfer) <input type="text" name="accountno"><br><br>
Amount: <input type="number" name="amount" required="required"><br><br>
<button name="submitbtn">Submit</button>
<button type="button" onclick="window.location.href='<%= request.getContextPath() %>/NewTransaction.jsp'">Cancel</button>
</form>
</body>
</html>