package com.sohambanking.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import com.sharayu.beans.CloudDBConnector;

/**
 * Servlet implementation class CloseAccount
 */
public class CloseAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no;
		Connection con;
		PreparedStatement pst;
		
		try
		{
			no=Integer.parseInt(request.getParameter("accno"));
			CloudDBConnector dbc=new CloudDBConnector();
			con=dbc.getDbconn();
			pst=con.prepareStatement("delete from accounts where accno=?");
			pst.setInt(1, no);
			pst.executeUpdate();
			response.sendRedirect("ClosedSuccess.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
			response.sendRedirect("ClosedFailed.jsp");
		}
		
		
		
	}

}
