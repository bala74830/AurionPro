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
import javax.servlet.http.HttpSession;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
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
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String role = request.getParameter("role");
		HttpSession session = request.getSession();

			try {
				if (role.equals("admin")) {
					Connection conn = DBConnection.getConnection();
					String query = "SELECT username FROM adminusers WHERE username = ?";
					PreparedStatement checkps = conn.prepareStatement(query);
					checkps.setString(1, user);
					ResultSet rs = checkps.executeQuery();
					if(rs.next())
					{
						pw.println("Username already exist..");
						pw.println("<br><a href='RegisterPage.jsp'>Go back</a>");
					}
					else
					{
					PreparedStatement ps = conn
							.prepareStatement("INSERT INTO adminusers (username, password) VALUES (?, ?)");
					ps.setString(1, user);
					ps.setString(2, pass);
					int count = ps.executeUpdate();
					if (count > 0) {
						pw.println("<h3>Registration Successfully</h3>");
						pw.println("<br><a href='LandingPage.jsp'>Go back</a>");
					} else {
						pw.println("<h3>Registeration Unsuccessfull</h3>");
						response.sendRedirect("RegisterPage.jsp");
					}
					
					}
				} else if (role.equals("customer")) {
					Connection conn = DBConnection.getConnection();
					String query = "SELECT username FROM customerusers WHERE username = ?";
					PreparedStatement checkps = conn.prepareStatement(query);
					checkps.setString(1, user);
					ResultSet rs = checkps.executeQuery();
					if(rs.next())
					{
						pw.println("Username already exist..");
						pw.println("<br><a href='RegisterPage.jsp'>Go back</a>");
					}
					else
					{
						session.setAttribute("username", user);
						session.setAttribute("password", pass);
						response.sendRedirect("CustomerRegister.jsp");
					}
				}
			}

			catch (Exception e) {
				e.printStackTrace();
				pw.println(e.getMessage());
			}
		
	}

//	private boolean isUsernameExists(String tableName, String username) throws ServletException {
//		String query = "SELECT username FROM " + tableName + " WHERE username = ?";
//		try {
//			Connection conn = DBConnection.getConnection();
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setString(1, username);
//			ResultSet rs = ps.executeQuery();
//			return rs.next(); // If there's a result, the username exists
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new ServletException("Database error while checking username existence", e);
//		}
//	}

}
