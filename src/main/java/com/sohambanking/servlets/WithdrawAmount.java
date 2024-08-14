package com.sohambanking.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sharayu.beans.CloudDBConnector;

/**
 * Servlet implementation class WithdrawAmount
 */
public class WithdrawAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawAmount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no;
		float amt;
		Connection con;
		PreparedStatement pst;
		
		try
		{
			no=Integer.parseInt(request.getParameter("accno"));
			//System.out.println("Account Number is:" +no);
			amt=Float.parseFloat(request.getParameter("amount"));
			//System.out.println("amount is:" +amt);
			CloudDBConnector dbc=new CloudDBConnector();
			con=dbc.getDbconn();
			pst=con.prepareStatement("update accounts set balance=balance-? where accno=?");
			pst.setFloat(1, amt);
			pst.setInt(2, no);
			pst.executeUpdate();
			con.close();
			response.sendRedirect("TransSuccess.jsp");
		}
		
		
		catch(Exception e)
		{
			System.out.println(e);
			response.sendRedirect("TransFailed.jsp");
		}
	}

}
