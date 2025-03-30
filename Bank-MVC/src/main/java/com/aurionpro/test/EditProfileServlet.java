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
import javax.servlet.http.HttpSession;

@WebServlet("/editProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
        String username=(String)session.getAttribute("customerusername");
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try
		{
			Connection conn = DBConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement("Update customerusers set firstname=?,lastname=?,email=?,password=? where username=?");
			pst.setString(1, fname);
			pst.setString(2, lname);
			pst.setString(3, email);
			pst.setString(4, password);
			pst.setString(5, username);
			int update = pst.executeUpdate();
			if(update>0)
			{
				pw.println("Profile updated successfully");
				response.sendRedirect("CustomerHomePage.jsp");
			}
			else
			{
				pw.println("profile could not be updated");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			pw.println(e.getMessage());
		}
	}

}
