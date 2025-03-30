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

@WebServlet("/transactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    
	    response.setContentType("text/html");
	    PrintWriter pw = response.getWriter();

	    String typeOfTransaction = request.getParameter("type");
	    String amountStr = request.getParameter("amount");
	    String receiverAccStr = request.getParameter("accountno");  // For transfer transactions
	    HttpSession session = request.getSession();


	    String username = (String) session.getAttribute("customerusername");

	    if (amountStr == null || amountStr.isEmpty()) {
	        pw.println("Amount is missing.");
	        pw.println("<br><a href='NewTransaction.jsp'>Go back</a>");
	        return;
	    }

	    double amount;
	    try {
	        amount = Double.parseDouble(amountStr);
	    } catch (NumberFormatException e) {
	        pw.println("Invalid amount format.");
	        pw.println("<br><a href='NewTransaction.jsp'>Go back</a>");
	        return;
	    }
	    
	    if (!isValidAmount(amount, pw)) {
	        return;
	    }

	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        conn = DBConnection.getConnection();
	        conn.setAutoCommit(false);

	        // Get sender details
	        ps = conn.prepareStatement("SELECT accno, balance FROM customerusers WHERE username = ?");
	        ps.setString(1, username);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            int senderAccNo = rs.getInt("accno");
	            double balance = rs.getDouble("balance");

	            if ("debit".equalsIgnoreCase(typeOfTransaction)) {
	                if (balance < amount) {
	                    pw.println("Insufficient Balance.");
	                    pw.println("<br><a href='NewTransaction.jsp'>Go back</a>");
	                    return;
	                } else {
	                    balance -= amount;
	                    updateBalance(conn, balance, username, pw);
	                    insertTransaction(conn, senderAccNo, senderAccNo, "Debit", amount, pw);
	                }
	            } else if ("credit".equalsIgnoreCase(typeOfTransaction)) {
	                balance += amount;
	                updateBalance(conn, balance, username, pw);
	                insertTransaction(conn, senderAccNo, senderAccNo, "Credit", amount, pw);
	            } else if ("transfer".equalsIgnoreCase(typeOfTransaction)) {
	                
	                if (receiverAccStr == null || receiverAccStr.isEmpty()) {
	                    pw.println("Receiver account number is required for transfer.");
	                    pw.println("<br><a href='NewTransaction.jsp'>Go back</a>");
	                    return;
	                }

	                int receiverAccNo;
	                try {
	                    receiverAccNo = Integer.parseInt(receiverAccStr);
	                } catch (NumberFormatException e) {
	                    pw.println("Invalid receiver account number.");
	                    return;
	                }

	                if (senderAccNo == receiverAccNo) {
	                    pw.println("Sender and Receiver cannot have the same account number.");
	                    return;
	                }

	                if (balance < amount) {
	                    pw.println("Insufficient balance for transfer.");
	                    return;
	                }

	                // Withdraw from sender
	                PreparedStatement wps = conn.prepareStatement("UPDATE customerusers SET balance = balance - ? WHERE accno = ?");
	                wps.setDouble(1, amount);
	                wps.setInt(2, senderAccNo);
	                int wrs = wps.executeUpdate();

	                // Deposit to receiver
	                PreparedStatement dps = conn.prepareStatement("UPDATE customerusers SET balance = balance + ? WHERE accno = ?");
	                dps.setDouble(1, amount);
	                dps.setInt(2, receiverAccNo);
	                int drs = dps.executeUpdate();

	                if (wrs > 0 && drs > 0) {
	                    conn.commit();
	                    pw.println("Amount transferred successfully.");
	                    
	                    PreparedStatement tst = conn.prepareStatement("INSERT INTO transaction (sender_acc, receiver_acc, type_of_transaction, amount) VALUES (?, ?, ?, ?)");
	                    tst.setInt(1, senderAccNo);
	                    tst.setInt(2, receiverAccNo);
	                    tst.setString(3, "Transfer");
	                    tst.setDouble(4, amount);
	                    
	                    int trs = tst.executeUpdate();
	                    if (trs > 0) {
	                        pw.println("Transaction recorded successfully.");
	                        conn.commit();
	                        pw.println("<br><a href='CustomerHomePage.jsp'>Go back</a>");
	                    } else {
	                        pw.println("Could not record transaction.");
	                    }
	                } else {
	                    conn.rollback();
	                    pw.println("Transfer unsuccessful.");
	                }
	            } else {
	                pw.println("Invalid transaction type.");
	                pw.println("<br><a href='NewTransaction.jsp'>Go back</a>");
	            }

	        } else {
	            pw.println("User not found.");
	            pw.println("<br><a href='NewTransaction.jsp'>Go back</a>");
	        }

	    } catch (Exception e) {
	        if (conn != null) {
	            try {
	                conn.rollback();
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	        pw.println("Error: " + e.getMessage());
	        pw.println("<br><a href='NewTransaction.jsp'>Go back</a>");
	    } 
	}

	private void insertTransaction(Connection conn, int sender, int receiver, String type, double amount, PrintWriter pw) {
	    try 
	    {
	    	PreparedStatement pst = conn.prepareStatement("INSERT INTO transaction (sender_acc, receiver_acc, type_of_transaction, amount) VALUES (?, ?, ?, ?)");
	        pst.setInt(1, sender);
	        pst.setInt(2, receiver);
	        pst.setString(3, type);
	        pst.setDouble(4, amount);

	        int rows = pst.executeUpdate();
	        if (rows > 0) {
	            pw.println("Transaction recorded successfully.");
	            conn.commit();
	            pw.println("<br><a href='CustomerHomePage.jsp'>Go back</a>");
	        } else {
	            pw.println("Failed to record transaction.");
	            pw.println("<br><a href='NewTransaction.jsp'>Go back</a>");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        pw.println("Error: " + e.getMessage());
	        pw.println("<br><a href='NewTransaction.jsp'>Go back</a>");
	    }
	}

	private void updateBalance(Connection conn, double balance, String username, PrintWriter pw) throws Exception {
	    try 
	    {
	    	PreparedStatement updatePs = conn.prepareStatement("UPDATE customerusers SET balance = ? WHERE username = ?") ;
	        updatePs.setDouble(1, balance);
	        updatePs.setString(2, username);
	        int rowsUpdated = updatePs.executeUpdate();

	        if (rowsUpdated > 0) {
	            pw.println("Balance updated successfully.");
	            conn.commit();
	        } else {
	            pw.println("Failed to update balance.");
	            pw.println("<br><a href='NewTransaction.jsp'>Go back</a>");
	        }
	    }
	    catch(Exception e)
	    {
	    	pw.println(e.getMessage());
	    }
	}

	private boolean isValidAmount(double amount, PrintWriter pw) {
	    if (amount <= 0) {
	        pw.println("Transaction amount must be greater than zero.");
	        pw.println("<br><a href='NewTransaction.jsp'>Go back</a>");
	        return false;
	    }
	    return true;
	}
}
