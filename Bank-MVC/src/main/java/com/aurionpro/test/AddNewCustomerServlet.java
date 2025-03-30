package com.aurionpro.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addNewCustomerServlet")
public class AddNewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        
        try
        {
        	Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO customerusers (username,firstname,lastname,email,password,accno,balance) VALUES (?, ? , ? , ? , ? , ? ,?)");
			ps.setString(1, user);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setString(4, email);
			ps.setString(5, pass);
			ps.setString(6, null);
			ps.setInt(7, 0);
			int count = ps.executeUpdate();
			if(count>0)
			{
				 pw.println("<h3>Registration Successfull</h3>");
				 response.sendRedirect("AdminHomePage.jsp");;
			}
			else
			{
				pw.println("<h3>Registration Unsuccessfull</h3>");
				response.sendRedirect("AdminHomePage.jsp");
			}
        }
        catch(Exception e)
        {
        	e.printStackTrace();
			pw.println(e.getMessage());
        }
	}

}
