package com.aurionpro.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/generateRandomServlet")
public class GenerateRandomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();

	        String customerId = request.getParameter("customerId");

	        if (customerId == null || customerId.isEmpty()) {
	            pw.println("<h3>Error: Customer ID is missing or invalid.</h3>");
	            return;
	        }

	        Connection conn = null;

	        try {
	            conn = DBConnection.getConnection();
	            int customerIdInt = Integer.parseInt(customerId);
	            PreparedStatement checkStmt= null;
	            checkStmt = conn.prepareStatement("SELECT accno FROM customerusers WHERE id = ?");
	            checkStmt.setInt(1, customerIdInt);
	            ResultSet rst = checkStmt.executeQuery();

	            if (rst.next() && rst.getLong("accno") != 0) { // If accno exists and is non-zero
	                pw.println("<h3 style='color:blue;'>Customer already has an account number: <b>" + rst.getLong("accno") + "</b></h3>");
	                pw.println("<br><a href='AdminHomePage.jsp'>Go back</a>");
	                return;
	            }
	            
	            
	            long randomNumber = (long) (Math.random() * 1000 + 1);
	            PreparedStatement updateStmt = conn.prepareStatement("UPDATE customerusers SET accno = ? WHERE id = ?");
	            updateStmt.setLong(1, randomNumber);
	            updateStmt.setInt(2, customerIdInt);

	            int updateCount = updateStmt.executeUpdate();

	            if (updateCount > 0) {
	                pw.println("<h2>Account Number Generated and Updated Successfully</h2>");
	                pw.println("<h3>Account Number: </h3>" + randomNumber);
	            } else {
	                pw.println("<h3>Failed to update account number. Customer ID not found.</h3>");
	                return;
	            }

	            
	            PreparedStatement selectStmt = conn.prepareStatement(
	                "SELECT id, firstname, lastname, email, accno, balance FROM customerusers WHERE id = ?");
	            
	            selectStmt.setInt(1, customerIdInt);
	            ResultSet rs = selectStmt.executeQuery();

	            
	            if (rs.next()) {
	                pw.println("<h3>Customer Details</h3>");
	                pw.println("<table border='1'>");
	                pw.println("<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Account No</th><th>Balance</th></tr>");
	                pw.println("<tr>");
	                pw.println("<td>" + rs.getInt("id") + "</td>");
	                pw.println("<td>" + rs.getString("firstname") + "</td>");
	                pw.println("<td>" + rs.getString("lastname") + "</td>");
	                pw.println("<td>" + rs.getString("email") + "</td>");
	                pw.println("<td>" + rs.getLong("accno") + "</td>");
	                pw.println("<td>" + rs.getInt("balance") + "</td>");
	                pw.println("</tr>");
	                pw.println("</table>");
	                pw.println("<br><a href='AdminHomePage.jsp'>Go back</a>");
	            } else {
	                pw.println("<h3>No customer details found for ID: " + customerId + "</h3>");
	            }

	        } catch (SQLException e) {
	            pw.println("<h3>Database error occurred: </h3>" + e.getMessage());
	            e.printStackTrace();
	        } catch (Exception e) {
	            pw.println("<h3>An unexpected error occurred: </h3>" + e.getMessage());
	            e.printStackTrace();
	        } 
	}

}
