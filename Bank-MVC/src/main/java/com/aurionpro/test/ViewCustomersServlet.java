package com.aurionpro.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewCustomersServlet")
public class ViewCustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try
        {
        	Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("Select * from customerusers");
			ResultSet rs = ps.executeQuery();
			pw.println("<h1>Customer List</h1>");
			pw.println("<br><br>");
			pw.println("<table border = '2'>");
			pw.println("<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Account Number</th><th>Balance</th></tr>");
			
			while(rs.next())
			{
				pw.println("<tr>");
				pw.println("<td>" + rs.getInt("id") + "</td>");
				pw.println("<td>" + rs.getString("firstname") + "</td>");
				pw.println("<td>" + rs.getString("lastname") + "</td>");
				pw.println("<td>" + rs.getString("email") + "</td>");
				pw.println("<td>" + rs.getString("accno") + "</td>");
				pw.println("<td>" + rs.getString("balance") + "</td>");
				pw.println("</tr>");
			}
			
			pw.println("</table>");
			pw.println("<br><a href='AdminHomePage.jsp'>Go back to Home</a>");
		}catch(Exception e)
		{
			e.printStackTrace();
            pw.println("<h3>Exception Occurred: " + e.getMessage() + "</h3>");
            pw.println("<br><a href='AdminHomePage.jsp'>Go back to Home</a>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
