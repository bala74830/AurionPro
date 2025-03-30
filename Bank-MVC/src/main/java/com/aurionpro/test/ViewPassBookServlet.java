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


@WebServlet("/viewPassBookServlet")
public class ViewPassBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		int accountnumber=0;
		String username = (String) session.getAttribute("customerusername");
		try
        {
        	Connection conn = DBConnection.getConnection();
        	PreparedStatement pst = conn.prepareStatement("Select * from customerusers where username=?");
    		pst.setString(1, username);
    		ResultSet rst = pst.executeQuery();
    		if(rst.next())
    		{
    			 accountnumber=rst.getInt("accno");
    		}
    		else
    		{
    			pw.println("Username not found");
    		}
        	
        	
    		PreparedStatement ps = conn.prepareStatement("Select * from transaction where sender_acc=?");
    		ps.setInt(1, accountnumber);
			ResultSet rs = ps.executeQuery();
			pw.println("<h1>Transaction</h1>");
			pw.println("<br><br>");
			pw.println("<table border = '2'>");
			pw.println("<tr><th>ID</th><th>Sender Account No</th><th>Receiver Account No</th><th>Type of Transaction</th><th>Amount</th><th>Date</th></tr>");
			
			while(rs.next())
			{
				pw.println("<tr>");
				pw.println("<td>" + rs.getInt("id") + "</td>");
				pw.println("<td>" + rs.getString("sender_acc") + "</td>");
				pw.println("<td>" + rs.getString("receiver_acc") + "</td>");
				pw.println("<td>" + rs.getString("type_of_transaction") + "</td>");
				pw.println("<td>" + rs.getString("amount") + "</td>");
				pw.println("<td>" + rs.getString("date") + "</td>");
				pw.println("</tr>");
			}
			
			pw.println("</table>");
			pw.println("<br><a href='CustomerHomePage.jsp'>Go back to Home</a>");
		}catch(Exception e)
		{
			e.printStackTrace();
            pw.println("<h3>Exception Occurred: " + e.getMessage() + "</h3>");
            pw.println("<br><a href='CustomerHomePage.jsp'>Go back to Home</a>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
