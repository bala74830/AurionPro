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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
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
        String role = request.getParameter("role");
        HttpSession session = request.getSession();
        
        if (role == null || (!role.equals("admin") && !role.equals("customer"))) {
			pw.println("Invalid role selected.");
			return;
		}
        
        try
		{
        	if(role.equals("admin"))
        	{
        		Connection conn = DBConnection.getConnection();
    			PreparedStatement ps = conn.prepareStatement("Select * from adminusers where username=? and password=?");
    			ps.setString(1, user);
    			ps.setString(2, pass);
    			ResultSet  rs = ps.executeQuery();
    			if(rs.next())
    			{
    				response.sendRedirect("AdminHomePage.jsp");
    				session.setAttribute("adminusername", user);
    			}
    			else
    			{
    				pw.println("<h3>User not found</h3>");
    				response.sendRedirect("LoginPage.jsp");
    			}
        	}
        	else if(role.equals("customer"))
        	{
        		Connection conn = DBConnection.getConnection();
    			PreparedStatement ps = conn.prepareStatement("Select * from customerusers where username=? and password=?");
    			ps.setString(1, user);
    			ps.setString(2, pass);
    			ResultSet  rs = ps.executeQuery();
    			if(rs.next())
    			{
    				response.sendRedirect("CustomerHomePage.jsp");
    				session.setAttribute("customerusername", user);
    			}
    			else
    			{
    				pw.println("<h3>User not found</h3>");
    				response.sendRedirect("LoginPage.jsp");
    			}
        	}
        	else
        	{
        		pw.println("Choose a role");
        	}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			pw.println(e.getMessage());
		}
	}

}
